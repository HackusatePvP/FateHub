package me.Hackusate_PvP.FateHub.Profiles;

import me.Hackusate_PvP.FateHub.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.HashSet;
import java.util.UUID;

public class ProfileManager implements Listener {
    private static HashSet<UUID> register = new HashSet<>();
    private static HashSet<UUID> login = new HashSet<>();

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPlayedBefore()) {
            player.sendMessage(Main.getPlugin().getAPI().getCc().format("&cThanks for joining the server! To continue you must register. This helps keeps your account secure as well. Don't worry you only have to login with it every time you ip changes."));
            player.sendMessage(ChatColor.RED + "/register <password> <confirm password>");
            player.sendMessage(ChatColor.GREEN + "Loading Default Profile...");
            setRegister(player, true);
            Main.getPlugin().getAPI().getRegistryData().getConfig().set(player.getUniqueId() + "." + "register", false);
            Main.getPlugin().getAPI().getPlayerData().getConfig().set(player.getUniqueId() + "." + "name", player.getName());
            Main.getPlugin().getAPI().getPlayerData().getConfig().set(player.getUniqueId() + "." + "uuid", player.getUniqueId().toString());
            Main.getPlugin().getAPI().getPlayerData().getConfig().set(player.getUniqueId() + "." + "ip", player.getAddress().getHostString());
            Main.getPlugin().getAPI().getPlayerData().getConfig().set(player.getUniqueId() + "." + "scoreboard", true);
            Main.getPlugin().getAPI().getPlayerData().getConfig().set(player.getUniqueId() + "." + "tablist", true);
            Main.getPlugin().getAPI().getPlayerData().getConfig().set(player.getUniqueId() + "." + "doublejump", true);
            Main.getPlugin().getAPI().getPlayerData().getConfig().set(player.getUniqueId() + "." + "pop", false);
            Main.getPlugin().getAPI().getGenerator().genrateID(player);
            Main.getPlugin().getAPI().getRegistryData().saveConfig();
            Main.getPlugin().getAPI().getPlayerData().saveConfig();
            Main.getPlugin().getAPI().getSettingsManager().setBoard(player, true);
            player.sendMessage(ChatColor.GREEN + "[FateProfile] Scoreboard: true");
            Main.getPlugin().getAPI().getSettingsManager().setPlayersVanished(player, true);
            player.sendMessage(ChatColor.GREEN + "[FateProfile] PlayersVanished: true");
            Main.getPlugin().getAPI().getSettingsManager().setTablist(player, true);
            player.sendMessage(ChatColor.GREEN + "[FateProfile] Tablist: true");
            player.sendMessage(ChatColor.GREEN + "Finished Loading Default Profile!");
            Main.getPlugin().getAPI().getPlayerData().saveConfig();
            player.setGameMode(GameMode.ADVENTURE);


        } else {
            if (isRegister(player)) {
                player.sendMessage(ChatColor.RED + "I'm afraid you didn't finish registering your account the last time you logged in. Please do /register <password <confirm password> to continue the process.");
                setLogin(player, true);
            }
            if (!Main.getPlugin().getAPI().getRegistryData().getConfig().getBoolean(player.getUniqueId() + "." + "register")) {
                player.sendMessage(ChatColor.RED + "I'm afraid you didn't finish registering your account the last time you logged in. Please do /register <password <confirm password> to continue the process.");
                setRegister(player, true);
            }

            if (Main.getPlugin().getAPI().getPlayerData().getConfig().get(player.getUniqueId() + ".ip") != player.getAddress().getHostString()) {
                if (isRegister(player)) {
                    setRegister(player, true);
                } else if (!isLogin(player)) {
                    setLogin(player, true);
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location from = event.getFrom();
        Location to = event.getTo();
        if (isRegister(player) || (isLogin(player)) && (from.getBlockX() != to.getBlockX() || from.getBlockZ() != to.getBlockZ())) {
            event.setTo(from);
        }
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onCommand(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage();
        if (isLogin(player) || isRegister(player)) {
            if (!(message.contains("/login") || message.contains("/register"))) {
                event.setCancelled(true);
                player.sendMessage(ChatColor.RED + "Please login/register first!");
            }
        }
    }

    public boolean isRegister(Player player) {
        return register.contains(player.getUniqueId());
    }

    public void setRegister(Player player, boolean status) {
        if (status) {
            register.add(player.getUniqueId());
            Main.getPlugin().getAPI().getRegistryData().getConfig().set(player.getUniqueId() + ".register", false);
            Main.getPlugin().getAPI().getRegistryData().saveConfig();
        } else {
            register.remove(player.getUniqueId());
            Main.getPlugin().getAPI().getRegistryData().getConfig().set(player.getUniqueId() + ".register", true);
            Main.getPlugin().getAPI().getRegistryData().saveConfig();
            player.getInventory().setItem(0, Main.getPlugin().getAPI().getItemManager().getCompass(player));
            player.getInventory().setItem(2, Main.getPlugin().getAPI().getItemManager().getEnderPeal(player));
            player.getInventory().setItem(4, Main.getPlugin().getAPI().getItemManager().getSettings(player));
            player.getInventory().setItem(6, Main.getPlugin().getAPI().getItemManager().getCosmetics(player));
            player.setGameMode(GameMode.ADVENTURE);
        }
    }

    public boolean isLogin(Player player) {
        return login.contains(player.getUniqueId());
    }

    public void setLogin(Player player, boolean status) {
        if (status) {
            login.add(player.getUniqueId());
        } else {
            login.remove(player.getUniqueId());
            Main.getPlugin().getAPI().getPlayerData().getConfig().set(player.getUniqueId() + "." + "ip", player.getAddress().getHostString());
            Main.getPlugin().getAPI().getPlayerData().saveConfig();
            player.getInventory().setItem(0, Main.getPlugin().getAPI().getItemManager().getCompass(player));
            player.getInventory().setItem(2, Main.getPlugin().getAPI().getItemManager().getEnderPeal(player));
            player.getInventory().setItem(4, Main.getPlugin().getAPI().getItemManager().getSettings(player));
            player.getInventory().setItem(6, Main.getPlugin().getAPI().getItemManager().getCosmetics(player));
            player.setGameMode(GameMode.ADVENTURE);
        }
    }

    public static HashSet<UUID> getRegister() {
        return register;
    }

}