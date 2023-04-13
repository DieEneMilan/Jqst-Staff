package com.foxdev.jqststaff.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class VanishCommand implements CommandExecutor {

    private List<Player> vanishedPlayers = new ArrayList<Player>();


    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (!(sender instanceof Player)) {
            sender.sendMessage("Only Players");
            return true;
        }

        Player player = (Player) sender;


        if(!vanishedPlayers.contains(player)){
            for(Player onlinePlayer : Bukkit.getOnlinePlayers()){
                onlinePlayer.hidePlayer(player);
            }
            vanishedPlayers.add(player);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',  ("[&2JC&r] " + "You have vanished!")));
        } else {
            for(Player onlinePlayers : Bukkit.getOnlinePlayers()){
                onlinePlayers.showPlayer(player);
            }
            vanishedPlayers.remove(player);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "[&2JC&r] " + "You have unvanished!"));
        }


        return true;
    }
}
