package com.foxdev.jqststaff.Util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class PunishGUI implements Listener {

    private JavaPlugin plugin;
    private Map<String, Player> punishMap = new HashMap<String, Player>();

    public PunishGUI(JavaPlugin plugin){
        this.plugin = plugin;
    }

    public void openGUI(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 9, "Punish");

        ItemStack banHead = createHead("Ban", "Punish a player with a ban");
        inventory.setItem(0, banHead);

        ItemStack kickHead = createHead("Kick", "Punish a player with a kick");
        inventory.setItem(1, kickHead);

        ItemStack muteHead = createHead("Mute", "Punish a player with a mute");
        inventory.setItem(2, muteHead);

        player.openInventory(inventory);
    }

    private ItemStack createHead(String name, String lore) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD, 1);
        SkullMeta meta = (SkullMeta) head.getItemMeta();
        meta.setOwner("MHF_" + name.toUpperCase());
        meta.setDisplayName(name);
        meta.setLore(java.util.Arrays.asList(lore.split("\n")));
        head.setItemMeta(meta);
        return head;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getInventory().getType().equals("Punish")) {
            event.setCancelled(true);
            if (event.getCurrentItem() != null && event.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                Player clickedPlayer = punishMap.get(event.getWhoClicked().getName());
                if (clickedPlayer != null) {
                    String punishmentType = event.getCurrentItem().getItemMeta().getDisplayName();
                    switch (punishmentType) {
                        case "Ban":
                            // Do ban punishment
                            break;
                        case "Kick":
                            // Do kick punishment
                            break;
                        case "Mute":
                            // Do mute punishment
                            break;
                    }
                    clickedPlayer.closeInventory();
                }
            }
        }
    }

    public void addPlayerToPunishMap(Player player) {
        punishMap.put(player.getName(), player);
    }

    public void removePlayerFromPunishMap(Player player) {
        punishMap.remove(player.getName());
    }
}