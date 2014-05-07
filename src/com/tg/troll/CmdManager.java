package com.tg.troll;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.tg.troll.commands.FakeOp;
import com.tg.troll.commands.Fire;
import com.tg.troll.commands.Rocket;
import com.tg.troll.commands.TrollCmd;

public class CmdManager implements CommandExecutor {

	private ArrayList<TrollCmd> cmds = new ArrayList<TrollCmd>();

	public CmdManager() {
		cmds.add(new Fire());
		cmds.add(new Rocket());
		cmds.add(new FakeOp());
	}

	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("troll")) {
			if (args.length == 0) {
				sender.sendMessage(ChatColor.RED + "Troll Commands: ");
				for (TrollCmd c : cmds) {
					sender.sendMessage(ChatColor.GRAY + "/troll " + c.getName()
							+ " " + c.getArgs() + " - " + c.getDescription());
				}

				return true;
			}

		}
		ArrayList<String> a = new ArrayList<String>(Arrays.asList(args));
		a.remove(0);

		for (TrollCmd c : cmds) {
			if (c.getName().equalsIgnoreCase(args[0])) {
				try {
					c.run(sender, a.toArray(new String[a.size()]));
				} catch (Exception e) {
					sender.sendMessage(ChatColor.RED + "An error has occurred.");
					e.printStackTrace();
				}
				return true;
			}
		}

		sender.sendMessage(ChatColor.RED + "Invalid command!");

		return true;
	}
}
