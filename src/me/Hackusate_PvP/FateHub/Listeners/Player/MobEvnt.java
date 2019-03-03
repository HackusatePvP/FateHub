package me.Hackusate_PvP.FateHub.Listeners.Player;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class MobEvnt implements Listener {

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onMobSpawn(EntitySpawnEvent event) {
        if (!(event.getEntityType() == EntityType.PLAYER)) {
            event.setCancelled(true);
        }
    }
}
