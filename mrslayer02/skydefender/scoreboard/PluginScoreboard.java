package mrslayer02.skydefender.scoreboard;

import mrslayer02.skydefender.ConfigManager;
import mrslayer02.skydefender.SkyDefender;
import mrslayer02.skydefender.player.SkyDefPlayer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class PluginScoreboard {
	
	private static SkyDefender skydef = SkyDefender.getPlugin();
	
	private Scoreboard scoreboard;
	
	private int jour;
	private int minutes;
	private int secondes;
	
	public PluginScoreboard(){
		
		scoreboard = skydef.getServer().getScoreboardManager().getNewScoreboard();
		
		for(int i=0;i<ConfigManager.getNbTeams();i++){
			Team team = scoreboard.registerNewTeam("team"+i);
			SkyDefTeam skydefTeam = SkyDefTeam.getById(i);
			team.setPrefix(skydefTeam.getColor().toString());
			skydefTeam.setEnabled(true);
			skydefTeam.setTeam(team);
		}
		
		scoreboard.registerNewObjective("waiting", "dummy");
		
	}
	
	public void showWaitingScoreboard(){
		
		resetBoard();
		Objective o = scoreboard.getObjective("waiting");
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		o.setDisplayName(ChatColor.AQUA + "SkyDefender");
		
		o.getScore(ChatColor.GREEN + "En attente de joueurs").setScore(15);
		o.getScore(ChatColor.GREEN + "       (" + Bukkit.getOnlinePlayers().size() + "/" + ConfigManager.getNbTeams()*ConfigManager.getPlayersPerTeam()+")").setScore(14);;
		
		for(Player player : Bukkit.getOnlinePlayers()){
			player.getPlayer().setScoreboard(scoreboard);
		}
		
		
	}
	
	public void showGameScoreboard(SkyDefPlayer player){
		
		resetBoard();
		Objective o;
		try{
			o = scoreboard.registerNewObjective(player.getPlayer().getName(), "dummy");
		}
		catch(IllegalArgumentException e){
			o = scoreboard.getObjective(player.getPlayer().getName());
		}
		
		o.setDisplayName(ChatColor.AQUA + "SkyDefender");
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		
		o.getScore(ChatColor.GRAY + "Jour "+ ChatColor.WHITE + jour).setScore(15);
		
		String minutesString = Integer.toString(minutes);
		String secondesString = Integer.toString(secondes);
		if(minutes < 10){
			minutesString = "0" + minutesString;
		}
		if(secondes < 10){
			secondesString = "0"+ secondesString;
		}
		
		o.getScore(minutesString + ":"+ secondesString).setScore(14);
		o.getScore("").setScore(13);
		
		int nbPlayers = 0;
		for(Player p : Bukkit.getOnlinePlayers()){
			if(p.getGameMode() != GameMode.SPECTATOR){
				nbPlayers++;
			}
		}
		
		o.getScore(ChatColor.WHITE.toString() + nbPlayers + ChatColor.GRAY + " restants").setScore(12);
		
		player.getPlayer().setScoreboard(scoreboard);
		
	}
	
	private void resetBoard(){
		for(String s : scoreboard.getEntries()){
			scoreboard.resetScores(s);
		}
	}

}
