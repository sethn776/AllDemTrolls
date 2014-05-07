package com.tg.troll.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import com.tg.troll.utils.Utils;

public class Rocket extends TrollCmd {

	public Rocket() {
		super("rocket", "rocket a player into the air.", "<player>");
	}

	@SuppressWarnings("deprecation")
	public void run(CommandSender sender, String[] args) {
		if (!this.isAuthorized(sender, Perms.rocket)) {
			sender.sendMessage(ChatColor.RED
					+ "You do not have the correct permissions.");
			return;
		}

		if (args.length < 1 || args.length > 1) {
			sender.sendMessage(ChatColor.GRAY + "/troll rocket <player>");
			return;
		}

		final Player t = Bukkit.getServer().getPlayer(args[0]);
		if (t != null) {
			rocket(t);
			t.sendMessage(ChatColor.RED + "Your a spaceship WEEEE");
			sender.sendMessage(Utils.yes(t.getName()));
		}else {
			sender.sendMessage(ChatColor.RED + "Player is not online.");
		}

	}

	public void rocket(final Player t) {
		Vector velocity = t.getVelocity().setY(10);
		t.setVelocity(velocity);
	}

}
