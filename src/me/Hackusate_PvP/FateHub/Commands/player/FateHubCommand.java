package me.Hackusate_PvP.FateHub.Commands.player;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FateHubCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                player.sendMessage(ChatColor.GRAY + ChatColor.STRIKETHROUGH.toString() + "------------------------");
                player.sendMessage("");
                player.sendMessage(ChatColor.BLUE + ChatColor.BOLD.toString() + "FateHub " + ChatColor.GRAY + "made by " + ChatColor.RED + "Hackusate_PvP");
                player.sendMessage("");
                player.sendMessage(ChatColor.GRAY + ChatColor.STRIKETHROUGH.toString() + "------------------------");
            }
        }
        return false;
    }
}
