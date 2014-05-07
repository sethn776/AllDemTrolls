package com.tg.troll.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;

public abstract class TrollCmd {
	private String name, desc, args;

	public TrollCmd(String name, String desc, String args) {
		this.name = name;
		this.desc = desc;
		this.args = args;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return desc;
	}

	public String getArgs() {
		return args;
	}

	public abstract void run(CommandSender sender, String[] args);
	
	public boolean isAuthorized(CommandSender sender, Permission perm){
		if(sender.hasPermission(perm) || sender.isOp()) return true;
		else return false;
	}
}
