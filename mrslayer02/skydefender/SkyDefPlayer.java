package mrslayer02.skydefender;

import org.bukkit.entity.Player;

public class SkyDefPlayer {
	
	private Player player;
	
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
	

}
