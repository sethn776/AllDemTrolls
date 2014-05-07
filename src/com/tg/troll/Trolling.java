package com.tg.troll;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Trolling extends JavaPlugin implements Listener {
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
		this.getCommand("troll").setExecutor(new CmdManager());
	}
	
}
