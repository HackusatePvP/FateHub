package me.Hackusate_PvP.FateHub.Listeners.Inventories;

import me.Hackusate_PvP.FateHub.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.logging.Logger;

public class ServerSelectorManager implements Listener {
    private Logger log = Bukkit.getLogger();
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        if (!(Main.getPlugin().getAPI().getManager().isRegister(player) || Main.getPlugin().getAPI().getManager().isLogin(player))) {
            if (item != null) {
                if (item.getType() == Main.getPlugin().getAPI().getItemManager().getCompass(player).getType() && item.getItemMeta().getDisplayName().equals(Main.getPlugin().getAPI().getItemManager().getCompass(player).getItemMeta().getDisplayName())) {
                    if (item.getItemMeta().getDisplayName().equalsIgnoreCase(Main.getPlugin().getAPI().getItemManager().getCompass(player).getItemMeta().getDisplayName())) {
                        player.openInventory(Main.getPlugin().getAPI().getInventoryManager().getServerInventory(player));
                    }
                }
                if (item.getType() == Main.getPlugin().getAPI().getItemManager().getEnderPeal(player).getType()) {
                    //Seems to have an error if this isn't here lmaooooo
                }
            }
        } else {
            player.sendMessage(ChatColor.RED + "You need to login/register first.");
        }
    }

    @EventHandler
    public void onInvclick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getClickedInventory().getName().equalsIgnoreCase(Main.getPlugin().getAPI().getInventoryManager().getServerInventory(player).getName())) {
            event.setCancelled(true);
            if (event.getCurrentItem().getType() == Main.getPlugin().getAPI().getInventoryManager().getServers("hcf", player).getType() && event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Main.getPlugin().getAPI().getInventoryManager().getServers("hcf", player).getItemMeta().getDisplayName())) {
                if (Main.getPlugin().getAPI().getServerData().getConfig().getString("HCF.Status").equalsIgnoreCase("online")) {
                    player.performCommand("play hcf");
                } else if (Main.getPlugin().getAPI().getServerData().getConfig().getString("HCF.Status").equalsIgnoreCase("whitelist")) {
                    if (player.hasPermission("fatehub.whitelist.hcf.bypass")) {
                        player.performCommand("play hcf");
                    } else {
                        player.sendMessage(ChatColor.RED + "The server is whitelisted,");
                    }
                } else if (Main.getPlugin().getAPI().getServerData().getConfig().getString("HCF.Status").equalsIgnoreCase("offline")) {
                    player.sendMessage(ChatColor.RED + "The sever is offline.");
                }
            }
            if (event.getCurrentItem().getType() == Main.getPlugin().getAPI().getInventoryManager().getServers("kitpvp", player).getType() && event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Main.getPlugin().getAPI().getInventoryManager().getServers("kitpvp", player).getItemMeta().getDisplayName())) {
                if (Main.getPlugin().getAPI().getServerData().getConfig().getString("KitPvP.Status").equalsIgnoreCase("online")) {
                    player.performCommand("play kitpvp");
                } else if (Main.getPlugin().getAPI().getServerData().getConfig().getString("KitPvP.Status").equalsIgnoreCase("whitelist")) {
                    if (player.hasPermission("fatehub.whitelist.kitpvp.bypass")) {
                        player.performCommand("play kitpvp");
                    } else {
                        player.sendMessage(ChatColor.RED + "The server is whitelisted,");
                    }
                } else if (Main.getPlugin().getAPI().getServerData().getConfig().getString("KitPvP.Status").equalsIgnoreCase("offline")) {
                    player.sendMessage(ChatColor.RED + "The sever is offline.");
                }
            }
        }
    }
}
