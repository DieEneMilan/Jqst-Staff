package com.foxdev.jqststaff;

import com.foxdev.jqststaff.Commands.PunishCommand;
import com.foxdev.jqststaff.Commands.SocialSpyCommand;
import com.foxdev.jqststaff.Commands.VanishCommand;
import com.foxdev.jqststaff.Util.PunishGUI;
import org.bukkit.plugin.java.JavaPlugin;

public final class Jqst_Staff extends JavaPlugin {

    public static Jqst_Staff instance;

    @Override
    public void onEnable() {
        instance = this;
        getCommand("socialspy").setExecutor(new SocialSpyCommand());
        getCommand("vanish").setExecutor(new VanishCommand());
        getCommand("punish").setExecutor(new PunishCommand());
        getServer().getPluginManager().registerEvents(new PunishGUI(this), this);
        getServer().getPluginManager().registerEvents(new SocialSpyCommand(), this);
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
