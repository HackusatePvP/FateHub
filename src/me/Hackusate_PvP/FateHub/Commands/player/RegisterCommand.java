package me.Hackusate_PvP.FateHub.Commands.player;

import me.Hackusate_PvP.FateHub.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.logging.Logger;

public class RegisterCommand implements CommandExecutor {
    private Logger log = Bukkit.getLogger();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 0) {
                    player.sendMessage(ChatColor.RED + "Usage: /register <password> <confirmpassword>");
                } else {
                    if (args.length == 1) {
                        player.sendMessage(ChatColor.RED + "/register <" + args[0] + "> " + "<" + args[0] + ">");
                    }
                    if (args.length == 2) {
                        if (Main.getPlugin().getAPI().getManager().isRegister(player)) {
                            if (args[0].equalsIgnoreCase(args[1])) {
                                String password = args[0];
                                if (password.length() >= 3) {
                                    log.info("[Debug] Password is greater than 3 char");
                                    player.sendMessage(ChatColor.GREEN + "Thank you for registering to the server.");
                                    Main.getPlugin().getAPI().getManager().setRegister(player, false);
                                    Main.getPlugin().getAPI().getRegistryData().getConfig().set(player.getUniqueId() + ".password", password);
                                    Main.getPlugin().getAPI().saveConfgis();
                                    Main.getPlugin().getAPI().reloadConfigs();
                                } else {
                                    player.sendMessage(ChatColor.RED + "Your password must be at least 3 characters.");
                                }
                            } else {
                                player.sendMessage(ChatColor.RED + "Your password does not match. Try again.");
                            }
                        } else {
                            player.sendMessage(ChatColor.RED + "Either you are already registered or this maybe an error. If you have anymore issues contact an administrator");
                        }
                    }
                }
        } else {
            sender.sendMessage(ChatColor.DARK_RED + "You must be a player.");
        }
        return false;
    }
}
