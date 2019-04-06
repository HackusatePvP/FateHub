package me.Hackusate_PvP.FateHub.Listeners.Inventories;

import me.Hackusate_PvP.FateHub.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractEvnt implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (!(Main.getPlugin().getAPI().getManager().isLogin(player) || Main.getPlugin().getAPI().getManager().isRegister(player))) {
            if (event.getItem() != null) {
                if (event.getItem().getType() == Main.getPlugin().getAPI().getItemManager().getCosmetics(player).getType() && event.getItem().getItemMeta().getDisplayName().equals(Main.getPlugin().getAPI().getItemManager().getCosmetics(player).getItemMeta().getDisplayName())) {
                    player.openInventory(Main.getPlugin().getAPI().getInventoryManager().getCosmeticsInventory(player));
                }
                if (event.getItem().getType() == Main.getPlugin().getAPI().getItemManager().getEnderPeal(player).getType()) {
                    // Doesn't work unless this if statement is hear dk why but it just be like that sometimes
                }
                if (event.getItem().getType() == Main.getPlugin().getAPI().getItemManager().getSettings(player).getType() && event.getItem().getItemMeta().getDisplayName().equals(Main.getPlugin().getAPI().getItemManager().getSettings(player).getItemMeta().getDisplayName())) {
                    player.openInventory(Main.getPlugin().getAPI().getInventoryManager().getSettingsInventory(player));
                }
            }
        } else {
            player.sendMessage(ChatColor.RED + "You need to login/register first.");
        }
    }
}
