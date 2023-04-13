package com.foxdev.jqststaff.Commands;

import com.foxdev.jqststaff.Jqst_Staff;
import com.foxdev.jqststaff.Util.PunishGUI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PunishCommand implements CommandExecutor {


    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)){
            sender.sendMessage("Only players!");
            return true;
        }

        if(args.length == 1){
            Player target = Bukkit.getPlayer(args[0]);
            if(args != null){
                PunishGUI punishGUI = new PunishGUI(Jqst_Staff.instance);
                punishGUI.addPlayerToPunishMap(target);
                punishGUI.openGUI((Player) sender);
                return true;
            } else {
                sender.sendMessage("That player is not online.");
            return true;
            }
        } else {
            sender.sendMessage("Gebruik: /punish <player>");
            return true;
        }
    }
}
