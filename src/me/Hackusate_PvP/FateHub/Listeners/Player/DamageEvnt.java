package me.Hackusate_PvP.FateHub.Listeners.Player;


import me.Hackusate_PvP.FateHub.Main;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageEvnt implements Listener {

    @EventHandler
    public void onDanage(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            event.setCancelled(false);
        }
        if (event.getDamager().getType() != EntityType.PLAYER) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onD(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (Main.getPlugin().getAPI().getSettingsManager().hasPop(player)) {
                player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, (float)1.0, (float)1.0);
                event.setCancelled(true);
            }
            event.setCancelled(true);
        }
    }
}
