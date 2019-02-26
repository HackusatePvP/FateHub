package me.Hackusate_PvP.FateHub.Listeners.Inventories;

import me.Hackusate_PvP.FateHub.API;
import me.Hackusate_PvP.FateHub.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class StatusHandler implements Listener {

    @EventHandler
    public void onInvClick(InventoryClickEvent event) {
        API api = Main.getPlugin().getAPI();
        if (event.getWhoClicked() instanceof Player) {
            Player player = (Player) event.getWhoClicked();
            if (event.getClickedInventory().getName().equals(api.getInventoryManager().getStatusInventory(player).getName())) {
                event.setCancelled(true);
                if (event.getCurrentItem().getType() == api.getInventoryManager().getStatus("kitpvp", player).getType() && event.getCurrentItem().getItemMeta().getDisplayName().equals(api.getInventoryManager().getStatus("kitpvp", player).getItemMeta().getDisplayName())) {
                    if (api.getServerData().getConfig().getString("KitPvP.Status").equalsIgnoreCase("Online")) {
                        api.getServerData().getConfig().set("KitPvP.Status", "Offline");
                        player.sendMessage(ChatColor.RED + "KitPVP is now offline");
                        api.getServerData().saveConfig();
                        player.openInventory(api.getInventoryManager().getStatusInventory(player));
                    } else if (api.getServerData().getConfig().getString("KitPvP.Status").equalsIgnoreCase("Offline")) {
                        api.getServerData().getConfig().set("KitPvP.Status", "Whitelist");
                        player.sendMessage(ChatColor.WHITE + "KitPvP is now whitelisted.");
                        api.getServerData().saveConfig();
                        player.openInventory(api.getInventoryManager().getStatusInventory(player));
                    } else if (api.getServerData().getConfig().getString("KitPvP.Status").equalsIgnoreCase("Whitelist")){
                        api.getServerData().getConfig().set("KitPvP.Status", "Online");
                        player.sendMessage(ChatColor.GREEN + "KitPvP is now online");
                        api.getServerData().saveConfig();
                        player.openInventory(api.getInventoryManager().getStatusInventory(player));
                    }
                }
                if (event.getClickedInventory().getName().equalsIgnoreCase(api.getInventoryManager().getStatusInventory(player).getName())) {
                    if (event.getCurrentItem().getType() == api.getInventoryManager().getStatus("hcf", player).getType() && event.getCurrentItem().getItemMeta().getDisplayName().equals(api.getInventoryManager().getStatus("hcf", player).getItemMeta().getDisplayName())) {
                        event.setCancelled(true);
                        if (api.getServerData().getConfig().getString("HCF.Status").equalsIgnoreCase("Online")) {
                            api.getServerData().getConfig().set("HCF.Status", "Offline");
                            player.sendMessage(ChatColor.RED + "HCF is now offline");
                            api.saveConfgis();
                            api.reloadConfigs();
                            player.closeInventory();
                            player.openInventory(api.getInventoryManager().getStatusInventory(player));
                        } else if (api.getServerData().getConfig().getString("HCF.Status").equalsIgnoreCase("Offline")) {
                            api.getServerData().getConfig().set("HCF.Status", "Whitelist");
                            player.sendMessage(ChatColor.WHITE + "HCF is now whitelisted.");
                            api.getServerData().saveConfig();
                            player.closeInventory();
                            player.openInventory(api.getInventoryManager().getStatusInventory(player));
                        } else if (api.getServerData().getConfig().getString("HCF.Status").equalsIgnoreCase("Whitelist")) {
                            api.getServerData().getConfig().set("HCF.Status", "Online");
                            player.sendMessage(ChatColor.GREEN + "HCF is now online");
                            api.getServerData().saveConfig();
                            player.closeInventory();
                            player.openInventory(api.getInventoryManager().getStatusInventory(player));
                        }
                    }
                }
            }
        }
    }

}
