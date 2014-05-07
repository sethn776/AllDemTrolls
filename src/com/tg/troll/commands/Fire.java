package com.tg.troll.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fire extends TrollCmd {
	public Fire() {
		super("fire", "set someone on fire", "<player> <amount>");
	}

	@SuppressWarnings("deprecation")
	public void run(CommandSender sender, String[] args) {
		if (!this.isAuthorized(sender, Perms.fire)) {
			sender.sendMessage(ChatColor.RED
					+ "You do not have the correct permissions");
			return;
		}
		if (args.length < 1) {
			sender.sendMessage(ChatColor.GRAY + "/troll fire <player> <amount>");
			return;
		}
		Player t = Bukkit.getServer().getPlayer(args[0]);
		int fire = 4;
		if (t != null) {
			try {
				fire = Integer.parseInt(args[1]);
			} catch (Exception e) {
				sender.sendMessage(ChatColor.GRAY
						+ "/troll fire <player> <amount>");
				return;
			}
			fire(t, fire);
			sender.sendMessage(ChatColor.GREEN + "Burned " + t.getName()
					+ " for " + fire + " seconds.");
		}
	}

	public void fire(Player p, int amnt) {
		p.setFireTicks(amnt * 20);
		p.sendMessage(ChatColor.RED + "Suns hot huh?");
	}
}
