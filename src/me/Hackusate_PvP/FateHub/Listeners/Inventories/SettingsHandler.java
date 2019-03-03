package me.Hackusate_PvP.FateHub.Listeners.Inventories;

import me.Hackusate_PvP.FateHub.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class SettingsHandler implements Listener {

    @EventHandler
    public void onInvClick(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player) {
            Player player = (Player) event.getWhoClicked();
            if (event.getClickedInventory().getName().equals(Main.getPlugin().getAPI().getInventoryManager().getSettingsInventory(player).getName())) {
                event.setCancelled(true);
                if (event.getCurrentItem().getType() == Main.getPlugin().getAPI().getInventoryManager().getSettings("tablist", player).getType()) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().equals(Main.getPlugin().getAPI().getInventoryManager().getSettings("tablist", player).getItemMeta().getDisplayName())) {
                        if (Main.getPlugin().getAPI().getSettingsManager().isTablist(player)) {
                            Main.getPlugin().getAPI().getSettingsManager().setTablist(player, false);
                            player.updateInventory();
                            player.sendMessage(ChatColor.RED + "You have disabled your tablist.");
                            Main.getPlugin().getAPI().getPlayerData().saveConfig();
                        } else {
                            Main.getPlugin().getAPI().getSettingsManager().setTablist(player, true);
                            player.updateInventory();
                            player.sendMessage(ChatColor.GREEN + "You have enabled your tablist.");
                            Main.getPlugin().getAPI().getPlayerData().saveConfig();
                        }
                    }
                }
                if (event.getCurrentItem().getType() == Main.getPlugin().getAPI().getInventoryManager().getSettings("scoreboard", player).getType()) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().equals(Main.getPlugin().getAPI().getInventoryManager().getSettings("scoreboard", player).getItemMeta().getDisplayName())) {
                        if (Main.getPlugin().getAPI().getSettingsManager().hasBoard(player)) {
                            Main.getPlugin().getAPI().getSettingsManager().setBoard(player, false);
                            player.updateInventory();
                            player.sendMessage(ChatColor.RED + "You have disabled your scoreboard.");
                        } else {
                            Main.getPlugin().getAPI().getSettingsManager().setBoard(player, true);
                            player.updateInventory();
                            player.sendMessage(ChatColor.GREEN + "You have enabled your scoreboard.");
                            Main.getPlugin().getAPI().getPlayerData().saveConfig();
                        }
                    }
                }
                if (event.getCurrentItem().getType() == Main.getPlugin().getAPI().getInventoryManager().getSettings("pvanish", player).getType()) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().equals(Main.getPlugin().getAPI().getInventoryManager().getSettings("pvanish", player).getItemMeta().getDisplayName())) {
                        if (Main.getPlugin().getAPI().getSettingsManager().isPlayersVanished(player)) {
                            Main.getPlugin().getAPI().getSettingsManager().setPlayersVanished(player, false);
                            player.updateInventory();
                            player.sendMessage(ChatColor.RED + "You have shown all players.");
                            Main.getPlugin().getAPI().getPlayerData().saveConfig();
                        } else {
                            Main.getPlugin().getAPI().getSettingsManager().setPlayersVanished(player, true);
                            player.updateInventory();
                            player.sendMessage(ChatColor.GREEN + "You are hiding all players.");
                            Main.getPlugin().getAPI().getPlayerData().saveConfig();
                        }
                    }
                }
                if (event.getCurrentItem().getType() == Main.getPlugin().getAPI().getInventoryManager().getSettings("doublejump", player).getType()) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().equals(Main.getPlugin().getAPI().getInventoryManager().getSettings("doublejump", player).getItemMeta().getDisplayName())) {
                        if (Main.getPlugin().getAPI().getSettingsManager().hasDoubleJump(player)) {
                            Main.getPlugin().getAPI().getSettingsManager().setDoubleJump(player, false);
                            player.updateInventory();
                            player.sendMessage(ChatColor.RED + "You have disabled doublejump.");
                            Main.getPlugin().getAPI().getPlayerData().saveConfig();
                        } else {
                            Main.getPlugin().getAPI().getSettingsManager().setDoubleJump(player, true);
                            player.updateInventory();
                            player.sendMessage(ChatColor.GREEN + "You have enabled doublejump.");
                            Main.getPlugin().getAPI().getPlayerData().saveConfig();
                        }
                    }
                }
                if (event.getCurrentItem().getType() == Main.getPlugin().getAPI().getInventoryManager().getSettings("chat", player).getType()) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().equals(Main.getPlugin().getAPI().getInventoryManager().getSettings("chat", player).getItemMeta().getDisplayName())) {
                        if (Main.getPlugin().getAPI().getSettingsManager().hasChat(player)) {
                            Main.getPlugin().getAPI().getSettingsManager().setChat(player, false);
                            player.updateInventory();
                            player.sendMessage(ChatColor.RED + "You have disabled chatting.");
                            Main.getPlugin().getAPI().getPlayerData().saveConfig();
                        } else {
                            Main.getPlugin().getAPI().getSettingsManager().setChat(player, true);
                            player.updateInventory();
                            player.sendMessage(ChatColor.GREEN + "You have enabled chatting.");
                            Main.getPlugin().getAPI().getPlayerData().saveConfig();
                        }
                    }
                }
            }
        }
    }
}
