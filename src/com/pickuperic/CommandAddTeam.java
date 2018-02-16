package com.pickuperic;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import net.md_5.bungee.api.ChatColor;

public class CommandAddTeam {
	
	public static boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (args.length < 3) {
			sender.sendMessage(ChatColor.RED + "Invalid arguments: /teams create <teamName> <teamColor>");
		} else {
			try {
				ChatColor.valueOf(args[2].toUpperCase());
				String teamColor = args[2].toUpperCase();
				String teamName = args[1];
				if (Teams.addTeam(teamName, teamColor) == true) {
					sender.sendMessage(ChatColor.GREEN + "Successfully added team " + ChatColor.valueOf(teamColor) + ChatColor.BOLD + teamName + 
					ChatColor.RESET + ChatColor.GREEN + " to list of teams.");
				} else {
					sender.sendMessage(ChatColor.RED + "Error: Team name already in use.");
				}
				
			} catch (IllegalArgumentException e) {
				sender.sendMessage(ChatColor.RED + "Invalid color. Please choose from: " + String.join(", ", Teams.availableColors));
			}
			
			return true; 
		}
		return true;
		
	}

}