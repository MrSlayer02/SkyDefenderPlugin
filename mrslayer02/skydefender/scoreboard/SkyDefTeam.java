package mrslayer02.skydefender.scoreboard;

import org.bukkit.ChatColor;
import org.bukkit.scoreboard.Team;

public enum SkyDefTeam {
	
	DEFENDERS("Défenseurs", ChatColor.WHITE, 0),
	ORANGE("Orange", ChatColor.RED, 1),
	PURPLE("Violette", ChatColor.DARK_PURPLE, 2),
	BLUE("BleueC", ChatColor.BLUE, 3),
	YELLOW("Jaune", ChatColor.YELLOW, 4),
	GREEN("Verte", ChatColor.GREEN, 5),
	ROSE("Rose", ChatColor.LIGHT_PURPLE, 6),
	DARK_GRAY("Gris Foncé", ChatColor.DARK_GRAY, 7),
	GRAY("Grise", ChatColor.GRAY, 8),
	AQUA("Aqua", ChatColor.AQUA, 9),
	GOLD("Dorée", ChatColor.GOLD, 10),
	DARK_BLUE("Bleue", ChatColor.DARK_BLUE, 11),
	DARK_AQUA("Turquoise", ChatColor.DARK_AQUA, 12),
	DARK_GREEN("Verte Foncé", ChatColor.DARK_GREEN, 13),
	RED("Rouge", ChatColor.DARK_RED, 14),
	BLACK("Noire", ChatColor.BLACK, 15);
	
	private ChatColor color;
	private int woolID;
	private String name;
	private Team team;
	private boolean enabled;
	
	private SkyDefTeam(String name, ChatColor color, int woolID){
		
		this.color = color;
		this.woolID = woolID;
		this.name = name;
		
		team = null;
		
	}
	
	public String getName(){
		return this.name;
	}
	
	public ChatColor getColor(){
		return this.color;
	}
	
	public int getWoolId(){
		return this.woolID;
	}
	
	public void setTeam(Team team){
		this.team = team;
	}
	
	public Team getTeam(){
		return this.team;
	}
	
	public boolean isEnabled(){
		return this.enabled;
	}
	
	public void setEnabled(boolean isEnabled){
		this.enabled = isEnabled;
	}
	
	public static SkyDefTeam getById(int id){
		
		switch(id){
			case 0 : return SkyDefTeam.DEFENDERS;
			case 1 : return SkyDefTeam.ORANGE;
			case 2 : return SkyDefTeam.PURPLE;
			case 3 : return SkyDefTeam.BLUE;
			case 4 : return SkyDefTeam.YELLOW;
			case 5 : return SkyDefTeam.GREEN;
			case 6 : return SkyDefTeam.ROSE;
			case 7 : return SkyDefTeam.DARK_GRAY;
			case 8 : return SkyDefTeam.GRAY;
			case 9 : return SkyDefTeam.AQUA;
			case 10 : return SkyDefTeam.GOLD;
			case 11 : return SkyDefTeam.DARK_BLUE;
			case 12 : return SkyDefTeam.DARK_AQUA;
			case 13 : return SkyDefTeam.DARK_GREEN;
			case 14 : return SkyDefTeam.RED;
			case 15 : return SkyDefTeam.BLACK;
		}
		
		throw new IllegalArgumentException();
		
	}
	
	

}
