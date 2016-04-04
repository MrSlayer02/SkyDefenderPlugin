package mrslayer02.skydefender.commands;

import mrslayer02.skydefender.SkyDefender;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TPDefCommand implements CommandExecutor {
	
	SkyDefender skydef = SkyDefender.getPlugin();

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		int x, y, z;
		
		try{
			x = Integer.parseInt(args[0]);
			y = Integer.parseInt(args[1]);
			z = Integer.parseInt(args[2]);
		}
		catch(NumberFormatException e){
			return false;
		}
		
		
		if(sender instanceof BlockCommandSender){
			Location commandBlockLocation = ((BlockCommandSender) sender).getBlock().getLocation();
			
			double nearestDistance = Double.MAX_VALUE;
			Player nearestPlayer = null;
			for(Player player : Bukkit.getOnlinePlayers()){
				if(player.getLocation().distanceSquared(commandBlockLocation) < nearestDistance){
					nearestPlayer = player;
					nearestDistance = player.getLocation().distanceSquared(commandBlockLocation);
				}
			}
			
			if(skydef.getSkyDefPlayer(nearestPlayer).isDefender()){
				nearestPlayer.teleport(new Location(commandBlockLocation.getWorld(), x, y, z));
				sender.sendMessage(ChatColor.GREEN + "Le joueur a été TP !");
			}
			else sender.sendMessage(ChatColor.RED + "Le joueur n'est pas un defenseur !");
			return true;
		}
		
		return false;
	}

}
