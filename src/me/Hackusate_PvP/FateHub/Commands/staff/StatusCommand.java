package me.Hackusate_PvP.FateHub.Commands.staff;

import me.Hackusate_PvP.FateHub.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StatusCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("fatehub.status")) {
                player.openInventory(Main.getPlugin().getAPI().getInventoryManager().getStatusInventory(player));
            } else {
                player.sendMessage(ChatColor.RED + "You do not have permissions to execute this command.");
            }
        }
        return false;
    }
}
