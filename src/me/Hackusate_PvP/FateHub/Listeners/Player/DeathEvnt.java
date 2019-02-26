package me.Hackusate_PvP.FateHub.Listeners.Player;

import me.Hackusate_PvP.FateHub.Main;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathEvnt implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity().getPlayer();
        player.spigot().respawn();
        player.sendMessage(ChatColor.RED + "You have seem to die when your are invincible. How bad can you get?");
        player.getInventory().setItem(6, Main.getPlugin().getAPI().getItemManager().getCosmetics(player));
        player.getInventory().setItem(4, Main.getPlugin().getAPI().getItemManager().getSettings(player));
        player.getInventory().setItem(2, Main.getPlugin().getAPI().getItemManager().getEnderPeal(player));
        player.getInventory().setItem(0, Main.getPlugin().getAPI().getItemManager().getCompass(player));
        player.setGameMode(GameMode.ADVENTURE);
    }
}
