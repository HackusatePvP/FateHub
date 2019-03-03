package me.Hackusate_PvP.FateHub.Listeners.Player;

import me.Hackusate_PvP.FateHub.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.spigotmc.event.entity.EntityDismountEvent;

public class EnderButtListener implements Listener {

    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void onProjectileLaunch(final ProjectileLaunchEvent e) {
        if (e.getEntity().getShooter() instanceof Player) {
            final Player p = (Player)e.getEntity().getShooter();
            if (e.getEntity() instanceof EnderPearl) {
                final Projectile proj = e.getEntity();
                if (proj.getType() == EntityType.ENDER_PEARL) {
                    p.spigot().setCollidesWithEntities(false);
                    proj.setPassenger((Entity)p);
                }
            }
        }
    }
    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void onEntityDismound(final EntityDismountEvent e) {
        if (e.getEntity() instanceof Player) {
            final Player p = (Player)e.getEntity();
            if (p != null && p.getVehicle() instanceof EnderPearl) {
                Entity pearl = p.getVehicle();
                p.spigot().setCollidesWithEntities(true);
                p.eject();
                pearl.remove();
                p.getInventory().setItem(2, Main.getPlugin().getAPI().getItemManager().getEnderPeal(p));
            }
        }
    }
}

