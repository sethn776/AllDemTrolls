package com.tg.troll;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.tg.troll.commands.Fire;

public class Trolling extends JavaPlugin implements Listener {
	public void osnEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (label.equalsIgnoreCase("troll")) {
			if (args.length == 0) {
				sender.sendMessage(ChatColor.GREEN
						+ "/troll <fire, kill, rocket, smite, slap> <player>");
				return false;
			}
			if (args.length < 4) {
				Fire.runFire(sender, args);
			}

		}
		return true;
	}

	public static void fire(CommandSender sender, Player target, int fire) {
		if (target instanceof Player) {
			sender.sendMessage(ChatColor.RED + "Set " + target.getName()
					+ " on fire for " + fire);
			target.setFireTicks(fire * 20);
			target.sendMessage(ChatColor.RED + "Sun is hot huh?");

		} else {
			sender.sendMessage(ChatColor.RED
					+ "Target is not a player or cannot be set on fire!");
			return;
		}
	}
}
