package me.Hackusate_PvP.FateHub.Commands.player;

import me.Hackusate_PvP.FateHub.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ResetInventory implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.getInventory().setItem(0, Main.getPlugin().getAPI().getItemManager().getCompass(player));
            player.getInventory().setItem(2, Main.getPlugin().getAPI().getItemManager().getEnderPeal(player));
            player.getInventory().setItem(4, Main.getPlugin().getAPI().getItemManager().getSettings(player));
            player.getInventory().setItem(6, Main.getPlugin().getAPI().getItemManager().getCosmetics(player));
            player.sendMessage(ChatColor.GREEN + "Your hotbar has been reset!");
        } else {
            sender.sendMessage(ChatColor.DARK_RED + "You must be a player.");
        }
        return false;
    }
}
