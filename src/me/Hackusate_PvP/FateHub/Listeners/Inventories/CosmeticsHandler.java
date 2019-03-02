package me.Hackusate_PvP.FateHub.Listeners.Inventories;

import me.Hackusate_PvP.FateHub.API;
import me.Hackusate_PvP.FateHub.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class CosmeticsHandler implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player) {
            API api = Main.getPlugin().getAPI();
            Player player = (Player) event.getWhoClicked();
            if (event.getClickedInventory().getName().equals(Main.getPlugin().getAPI().getInventoryManager().getCosmeticsInventory(player).getName())) {
                event.setCancelled(true);
                if (event.getCurrentItem().getType() == api.getInventoryManager().getCosmetics("test", player).getType() && event.getCurrentItem().getItemMeta().getDisplayName().equals(api.getInventoryManager().getCosmetics("test", player).getItemMeta().getDisplayName())) {
                    player.sendMessage(ChatColor.GREEN + "Cosmetic WORKS!");
                }
                if (event.getCurrentItem().getType() == api.getInventoryManager().getCosmetics("fly", player).getType() && event.getCurrentItem().getItemMeta().getDisplayName().equals(api.getInventoryManager().getCosmetics("fly", player).getItemMeta().getDisplayName())) {
                    if (player.getAllowFlight()) {
                        player.setAllowFlight(false);
                        player.sendMessage(ChatColor.RED + "You can no longer fly.");
                    } else {
                        player.setAllowFlight(true);
                        player.sendMessage(ChatColor.GREEN + "You can now fly.");
                    }
                }
                if (event.getCurrentItem().getType() == api.getInventoryManager().getCosmetics("pop", player).getType() && event.getCurrentItem().getItemMeta().getDisplayName().equals(api.getInventoryManager().getCosmetics("pop", player).getItemMeta().getDisplayName())) {
                    if (Main.getPlugin().getAPI().getSettingsManager().hasPop(player)) {
                        Main.getPlugin().getAPI().getSettingsManager().setPop(player, false);
                        player.sendMessage(ChatColor.RED + "You can no longer pop players.");
                    } else {
                        Main.getPlugin().getAPI().getSettingsManager().setPop(player, true);
                        player.sendMessage(ChatColor.GREEN + "You can now pop players.");
                    }
                }
            }
        }
    }
}
