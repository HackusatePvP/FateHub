package me.Hackusate_PvP.FateHub.Listeners.Player;

import io.github.thatkawaiisam.assemble.events.AssembleBoardCreateEvent;
import me.Hackusate_PvP.FateHub.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(null);
        if (!Main.getPlugin().getAPI().getManager().isRegister(player) || !Main.getPlugin().getAPI().getManager().isLogin(player)) {
            player.sendMessage(ChatColor.GREEN + "Loading profile settings...");
            player.sendMessage(ChatColor.GRAY + ChatColor.STRIKETHROUGH.toString() + "------------------------");
            if (Main.getPlugin().getAPI().getSettingsManager().isPlayersVanished(player)) {
                for (Player online : Bukkit.getOnlinePlayers()) {
                    player.hidePlayer(online);
                    player.sendMessage(ChatColor.BLUE + "Players: " + ChatColor.RED + "Hidden");
                }
            } else {
                for (Player online : Bukkit.getOnlinePlayers()) {
                    player.showPlayer(online);
                    player.sendMessage(ChatColor.BLUE + "Players: " + ChatColor.GREEN + "Shown");
                }
            }
            if (Main.getPlugin().getAPI().getSettingsManager().hasBoard(player)) {
                player.sendMessage(ChatColor.BLUE + "Scoreboard: " + ChatColor.GREEN + "On");
            } else {
                player.sendMessage(ChatColor.BLUE + "Scoreboard: " + ChatColor.RED + "Off");
            }
            if (Main.getPlugin().getAPI().getSettingsManager().isTablist(player)) {
                player.sendMessage(ChatColor.BLUE + "Tablist: " + ChatColor.GREEN + "Shown");
            } else {
                player.sendMessage(ChatColor.BLUE + "Tablist: " + ChatColor.RED + "Hidden");
            }
            player.sendMessage(ChatColor.GRAY + ChatColor.STRIKETHROUGH.toString() + "------------------------");
            player.getInventory().setItem(0, Main.getPlugin().getAPI().getItemManager().getCompass(player));
            player.getInventory().setItem(2, Main.getPlugin().getAPI().getItemManager().getEnderPeal(player));
            player.getInventory().setItem(4, Main.getPlugin().getAPI().getItemManager().getSettings(player));
            player.getInventory().setItem(6, Main.getPlugin().getAPI().getItemManager().getCosmetics(player));
            //TODO Join Message
        }
    }

    @EventHandler
    public void onBoardCreate(AssembleBoardCreateEvent event) {
        //Do what you want with the player object
    }
}
