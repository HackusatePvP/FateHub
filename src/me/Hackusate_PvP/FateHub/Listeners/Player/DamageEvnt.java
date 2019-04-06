package me.Hackusate_PvP.FateHub.Listeners.Player;


import me.Hackusate_PvP.FateHub.Main;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class DamageEvnt implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onDanage(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            event.setCancelled(false);
        }
        if (event.getDamager().getType() != EntityType.PLAYER) {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
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

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onItneract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.PHYSICAL) {

        }
    }
    private Player getDamager(Entity entity) {
        if (entity instanceof Player) {
            return (Player)entity;
        } else {
            if (entity instanceof Projectile) {
                Projectile projectile = (Projectile)entity;
                if (projectile.getShooter() != null && projectile.getShooter() instanceof Player) {
                    return (Player)projectile.getShooter();
                }
            }

            return null;
        }
    }


    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        Player damager = this.getDamager(event.getDamager());
        Player damaged = this.getDamager(event.getEntity());
        if (damager != null && damaged != null && damaged != damager) {
            damager.hidePlayer(damaged);
            damager.sendMessage(Main.getPlugin().getAPI().getCc().format("&eYou have spoofed &c" + damaged.getName() + "&e."));
            damager.getWorld().playSound(damager.getLocation(), Sound.CHICKEN_EGG_POP, 1.0F, 1.0F);
        }

    }
}