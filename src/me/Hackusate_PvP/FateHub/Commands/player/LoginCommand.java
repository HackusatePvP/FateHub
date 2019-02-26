package me.Hackusate_PvP.FateHub.Commands.player;

import me.Hackusate_PvP.FateHub.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

public class LoginCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                player.sendMessage(ChatColor.RED + "Usage: /login <password>");
            } else {
                if (!Main.getPlugin().getAPI().getManager().isRegister(player)) {
                    if (Main.getPlugin().getAPI().getManager().isLogin(player)) {
                        String attempt = args[0];
                        String password = Main.getPlugin().getAPI().getRegistryData().getConfig().getString(player.getUniqueId() + "." + "password");
                        if (attempt.equalsIgnoreCase(password)) {
                            player.sendMessage(ChatColor.GREEN + "Password is correct!");
                            Main.getPlugin().getAPI().getManager().setLogin(player, false);
                        } else {
                            player.sendMessage(ChatColor.RED + "Password is incorrect. Please try again.");
                        }
                    } else {
                        player.sendMessage(ChatColor.RED + "It appears you are already logged in. If this is an error contact an administrator.");
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You still need to register. Please do /register.");
                }
            }
        } else {
            sender.sendMessage(ChatColor.DARK_RED + "You must be a player.");
        }
        return false;
    }
}
