package me.Hackusate_PvP.FateHub.Listeners.Player;

import me.Hackusate_PvP.FateHub.API;
import me.Hackusate_PvP.FateHub.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEvnt implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        event.setCancelled(true);
        API api = Main.getPlugin().getAPI();
        if (api.getSettingsManager().hasChat(player)) {
            String message = "&7[&b&oHUB&7] &7[" + Main.getPermissions().getPrimaryGroup(player) + "]" + "&9" + player.getName() + " ";
            for (Player online : Bukkit.getOnlinePlayers()) {
                if (api.getSettingsManager().hasChat(online)) {
                    player.sendMessage(message);
                    online.sendMessage(message);
                }
            }
        } else {
            player.sendMessage(ChatColor.RED + "You have chatting disabled. Enable it in your settings.");
        }
    }
}
