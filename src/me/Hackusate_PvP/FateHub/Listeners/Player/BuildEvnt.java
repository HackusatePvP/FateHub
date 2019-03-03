package me.Hackusate_PvP.FateHub.Listeners.Player;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BuildEvnt implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("fatehub.build")) {
            if (!(player.getGameMode() == GameMode.CREATIVE)) {
                player.sendMessage(ChatColor.RED + "Are you in the right mode?");
                event.setCancelled(true);
            }
        } else {
            player.sendMessage(ChatColor.RED + "You do not have permission to break blocks.");
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("fatehub.build")) {
            if (!(player.getGameMode() == GameMode.CREATIVE)) {
                player.sendMessage(ChatColor.RED + "Are you in the right mode?");
                event.setCancelled(true);
            }
        } else {
            player.sendMessage(ChatColor.RED + "You do not have permission to break blocks.");
            event.setCancelled(true);
        }
    }
}
