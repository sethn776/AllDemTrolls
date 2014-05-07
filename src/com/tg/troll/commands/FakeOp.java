package com.tg.troll.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.tg.troll.utils.Utils;

public class FakeOp extends TrollCmd {

	public FakeOp() {
		super("fakeop", "fakeop a player.", "<player>");
	}

	@SuppressWarnings("deprecation")
	public void run(CommandSender sender, String[] args) {
		if (!this.isAuthorized(sender, Perms.fakeop)) {
			sender.sendMessage(ChatColor.RED
					+ "You do not have the correct permissions.");
			return;
		}

		if (args.length < 1 || args.length > 1) {
			sender.sendMessage(ChatColor.GRAY + "/troll fakeop <player>");
			return;
		}
		Player t = Bukkit.getServer().getPlayer(args[0]);
		if (t != null) {
			op(t);
			t.sendMessage(ChatColor.YELLOW + "You are now op!");
			sender.sendMessage(Utils.yes(t.getName()));
			for (Player s : Bukkit.getOnlinePlayers()) {
				if (this.isAuthorized(s, Perms.fakeop)) {
					Bukkit.broadcastMessage(ChatColor.YELLOW
							+ "[AllDemTrolls] " + t.getName()
							+ " is now a FakeOp!");
				}
			}
		}else{
			sender.sendMessage(ChatColor.RED + "Player is not online!");
		}
	}

	public void op(Player t) {
		Bukkit.broadcastMessage(ChatColor.GRAY.toString() + ChatColor.ITALIC
				+ "[CONSOLE: Opped " + t.getName() + "]");
	}

}
