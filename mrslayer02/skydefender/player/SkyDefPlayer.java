package mrslayer02.skydefender.player;

import mrslayer02.skydefender.scoreboard.SkyDefTeam;

import org.bukkit.entity.Player;

public class SkyDefPlayer {
	
	private Player player;
	
	private SkyDefTeam team;
	
	private boolean isLastDamagePlayer;
	

	public SkyDefPlayer(Player player) {
		this.player = player;
	}
	
	public Player getPlayer(){
		return this.player;
	}
	
	public boolean isDefender(){
		return true;
	}
	
	public void setIsLastDamagePlayer(boolean isLastDamagePlayer){
		this.isLastDamagePlayer = isLastDamagePlayer;
	}
	
	public boolean isLastDamagePlayer(){
		return isLastDamagePlayer;
	}
	
	public SkyDefTeam getTeam(){
		return this.team;
	}
	
	public void setTeam(SkyDefTeam team){
		if(team.isEnabled()){
			this.team = team;
		}
		else {
			throw new IllegalArgumentException("Tried to add player " + player.getName() + " to a disabled team !");
		}
	}
	

}
