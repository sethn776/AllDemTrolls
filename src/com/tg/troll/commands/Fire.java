package com.tg.troll.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.tg.troll.Trolling;

public class Fire {

	public static void runFire(CommandSender sender, String[] args) {
		if (args.length < 4) {
			sender.sendMessage(ChatColor.GRAY + "/troll fire <player> <length>");
		} else {
			if (args[0].equalsIgnoreCase("fire")) {
				Player t = Bukkit.getServer().getPlayer(args[1]);
				if (t == null) {
					sender.sendMessage(ChatColor.RED + "Player Is not Online");
					return;
				}
				int fire = 4;
				try {
					fire = Integer.parseInt(args[2]);
				} catch (Exception e) {
					sender.sendMessage(ChatColor.DARK_RED
							+ "An Error Has Occurred. \nPlease Contact the plugin creator!");
				}
				Trolling.fire(sender, t, fire);
			}
		}

	}
}
