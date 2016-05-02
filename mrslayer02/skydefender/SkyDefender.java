package mrslayer02.skydefender;

import java.io.File;
import java.util.HashMap;

import mrslayer02.skydefender.commands.TPDefCommand;
import mrslayer02.skydefender.player.SkyDefPlayer;
import mrslayer02.skydefender.scoreboard.PluginScoreboard;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class SkyDefender extends JavaPlugin {

	public boolean gameStarted;
	
	private HashMap<Player, SkyDefPlayer> skydefPlayers;
	
	private PluginScoreboard scoreboard;
	
	@Override
	public void onEnable(){
		
		gameStarted = false;
		
		if(!new File(getDataFolder(), "config.yml").exists()){
			this.saveDefaultConfig();
		}
		
		ConfigManager.loadConfig();
		
		scoreboard = new PluginScoreboard();
		
		getCommand("tpdef").setExecutor(new TPDefCommand());
		
		skydefPlayers = new HashMap<Player, SkyDefPlayer>();
		
		getServer().getPluginManager().registerEvents(new Listeners(), this);
		
	}
	
	@Override
	public void onDisable(){
		this.saveConfig();
	}
	
	public static SkyDefender getPlugin(){
		return SkyDefender.getPlugin(SkyDefender.class);
	}
	
	public PluginScoreboard getScoreboard(){
		return scoreboard;
	}
	
	public SkyDefPlayer getSkyDefPlayer(Player player){
		return skydefPlayers.get(player);
	}
	
	public void setSkyDefPlayer(Player p, SkyDefPlayer p1){
		skydefPlayers.put(p, p1);
	}
	
	public World getWorld(){
		return getServer().getWorlds().get(0);
	}
	

}
