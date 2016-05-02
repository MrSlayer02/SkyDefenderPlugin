package mrslayer02.skydefender;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {
	
	private static SkyDefender skydef = SkyDefender.getPlugin();
	private static FileConfiguration config;
	
	private static boolean isDeathMessageVanilla;
	private static boolean isDeathMessageAnonym;
	private static Sound deathSound;
	
	private static int waitingRoomMinY;
	private static Location waitingRoomSpawn;
	
	private static int nbTeams;
	private static int playersPerTeam;
	
	private static Location castle;
	
	public static void loadConfig(){
		
		config = skydef.getConfig();
		
		isDeathMessageVanilla = config.getBoolean("death-messages.vanilla-messages");
		isDeathMessageAnonym = config.getBoolean("death-messages.anonymes");
		deathSound = Sound.valueOf(config.getString("death-messages.sound").toUpperCase());
		
		waitingRoomMinY = config.getInt("waiting-room.minY");
		waitingRoomSpawn = new Location(skydef.getWorld(), 
				config.getInt("waiting-room.x"),
				config.getInt("waiting-room.y"),
				config.getInt("waiting-room.z"));
		
		nbTeams = skydef.getConfig().getInt("game.nb-teams");
		playersPerTeam = skydef.getConfig().getInt("game.players-per-team");
		
		castle = new Location(skydef.getWorld(), 
				config.getInt("castle.x"),
				config.getInt("castle.y"),
				config.getInt("castle.z"));
		
	}
	
	public static boolean isDeathMessageAnonym(){
		return isDeathMessageAnonym;
	}
	public static void setIsDeathMessageAnonym(boolean anonym){
		isDeathMessageAnonym = anonym;
		skydef.getConfig().set("death-messages.anonym", anonym);
	}
	
	public static Sound getDeathSound(){
		return deathSound;
	}
	public static void setDeathSound(Sound sound){
		deathSound = sound;
		skydef.getConfig().set("death-messages.sound", sound.name());
	}
	
	public static boolean isDeathMessagesVanilla(){
		return isDeathMessageVanilla;
	}
	public static void setIsDeathMessageVanilla(boolean arg){
		isDeathMessageVanilla = arg;
		skydef.getConfig().set("death-messages.vanilla-messages", arg);
	}
	
	public static int getWaitingRoomMinY(){
		return waitingRoomMinY;
	}
	public static void setWaitingRoomMinY(int arg){
		waitingRoomMinY = arg;
		skydef.getConfig().set("waiting-room.minY", arg);
	}
	
	public static Location getWaitingRoomSpawn(){
		return waitingRoomSpawn;
	}
	public static void setWaitingRoomSpawn(Location arg){
		waitingRoomSpawn = arg;
		skydef.getConfig().set("waiting-room.x", arg.getBlockX());
		skydef.getConfig().set("waiting-room.y", arg.getBlockY());
		skydef.getConfig().set("waiting-room.z", arg.getBlockZ());
	}
	
	public static int getNbTeams(){
		return nbTeams;
	}
	public static void setNbTeams(int arg){
		nbTeams = arg;
		skydef.getConfig().set("game.nb-teams", arg);
	}
	
	public static int getPlayersPerTeam(){
		return playersPerTeam;
	}
	public static void setPlayersPerTeam(int arg){
		playersPerTeam = arg;
		skydef.getConfig().set("game.players-per-team", arg);
	}

}
