package mrslayer02.skydefender;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Listeners implements Listener {
	
	SkyDefender skydef = SkyDefender.getPlugin();
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){
		
		if(skydef.gameStarted){
			e.getPlayer().setGameMode(GameMode.SPECTATOR);
			e.setJoinMessage("");
			e.getPlayer().sendMessage(ChatColor.AQUA + "Vous êtes désormais un spectateur !");
		}
		else {
			e.getPlayer().setGameMode(GameMode.ADVENTURE);
			e.getPlayer().setAllowFlight(true);
			e.getPlayer().teleport(e.getPlayer().getLocation().getWorld().getSpawnLocation());
			e.setJoinMessage(ChatColor.RED + e.getPlayer().getName() + ChatColor.AQUA + " a rejoint la partie !");
		}
		
		skydef.setSkyDefPlayer(e.getPlayer(), new SkyDefPlayer(e.getPlayer()));
		
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e){
		skydef.setSkyDefPlayer(e.getPlayer(), null);
	}
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e){
		
		e.getEntity().setGameMode(GameMode.SPECTATOR);
		
		SkyDefPlayer player = skydef.getSkyDefPlayer(e.getEntity());
		
		if(player.isDefender()){
			if(player.isLastDamagePlayer()){
				e.setDeathMessage(ChatColor.RED + "Un défenseur a été tué !");
			}
			else e.setDeathMessage(ChatColor.RED + "Un défenseur est mort !");
		}
		else {
			if(player.isLastDamagePlayer()){
				e.setDeathMessage(ChatColor.RED + "Un attaquant a été tué !");
			}
			else e.setDeathMessage(ChatColor.RED + "Un attaquant est mort !");
		}
		
		for(Player p : Bukkit.getOnlinePlayers()){
			p.playSound(p.getLocation(), Sound.ENTITY_WITHER_DEATH, 16, 16);
		}
		
	}
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent e){
		
		if(e.getEntity() instanceof Player){
			
			Player p = (Player) e.getEntity();
			
			if(e instanceof EntityDamageByEntityEvent){
				
				EntityDamageByEntityEvent event = (EntityDamageByEntityEvent) e;
				
				if(event.getDamager() instanceof Player){
					skydef.getSkyDefPlayer(p).setIsLastDamagePlayer(true);
				}
				else skydef.getSkyDefPlayer(p).setIsLastDamagePlayer(false);
			}
			else skydef.getSkyDefPlayer(p).setIsLastDamagePlayer(false);
		}
		
	}
	


}
