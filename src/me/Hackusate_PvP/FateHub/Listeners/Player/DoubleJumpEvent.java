package me.Hackusate_PvP.FateHub.Listeners.Player;

import me.Hackusate_PvP.FateHub.Main;
import org.bukkit.*;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class DoubleJumpEvent implements Listener {

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (event.getPlayer().getGameMode() != GameMode.CREATIVE && event.getPlayer().getLocation().getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR) {
            event.getPlayer().setAllowFlight(true);
        }

    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onFly(PlayerToggleFlightEvent event) {
        Player player = event.getPlayer();
        if (player.getGameMode() != GameMode.CREATIVE) {
            if (Main.getPlugin().getAPI().getSettingsManager().hasDoubleJump(player)) {
                event.setCancelled(true);
                player.setAllowFlight(false);
                player.setFlying(false);
                if (Main.getPlugin().config.getInt("DoubleJump.Multiplier") > 12) {
                    Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "You doublejump multiplier is to big. Has to bee less than or equal to 12");
                } else {
                    player.setVelocity(player.getLocation().getDirection().multiply(Main.getPlugin().config.getInt("DoubleJump.Multiplier")).setY(1.0D));
                    player.playEffect(player.getLocation(), Effect.BLAZE_SHOOT, 5);
                }
            }
        }
    }
}
