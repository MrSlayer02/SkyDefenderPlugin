package mrslayer02.skydefender;

import java.io.File;
import java.util.HashMap;

import mrslayer02.skydefender.commands.TPDefCommand;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class SkyDefender extends JavaPlugin {
	
	FileConfiguration config;
	
	public boolean gameStarted;
	
	private HashMap<Player, SkyDefPlayer> skydefPlayers;
	
	@Override
	public void onEnable(){
		
		gameStarted = false;
		
		if(!new File(getDataFolder(), "config.yml").exists()){
			this.saveDefaultConfig();
		}
		
		config = this.getConfig();
		
		getCommand("tpdef").setExecutor(new TPDefCommand());
		
		skydefPlayers = new HashMap<Player, SkyDefPlayer>();
		
		getServer().getPluginManager().registerEvents(new Listeners(), this);
		
	}
	
	public static SkyDefender getPlugin(){
		return SkyDefender.getPlugin(SkyDefender.class);
	}
	
	@Override
	public void onDisable(){
		this.saveConfig();
	}
	
	public SkyDefPlayer getSkyDefPlayer(Player player){
		return skydefPlayers.get(player);
	}
	
	public void setSkyDefPlayer(Player p, SkyDefPlayer p1){
		skydefPlayers.put(p, p1);
	}
	

}
