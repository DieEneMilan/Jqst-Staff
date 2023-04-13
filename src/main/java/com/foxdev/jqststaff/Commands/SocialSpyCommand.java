package com.foxdev.jqststaff.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;
import java.util.List;

public class SocialSpyCommand implements CommandExecutor, Listener {

    private List<Player> socialSpies = new ArrayList<Player>();

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)){

            sender.sendMessage("Only Players");
            return true;
        }


        Player player = (Player) sender;

        if(socialSpies.contains(player)){
            socialSpies.remove(player);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "[&2JC&r] " + "Socialspy is now disabled."));
        } else {
            socialSpies.add(player);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "[&2JC&r] " + "Socialspy is now enabled."));

        }

        return true;
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();
        if(socialSpies.contains(player)){
            for(Player onlinePlayer : Bukkit.getOnlinePlayers()){
                if(socialSpies.contains(onlinePlayer)) continue;
                onlinePlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', "[&2JC&rSpy] " + player.getName() + ": " + event.getMessage()));
            }
        }
    }
}
