package me.Hackusate_PvP.FateHub.Commands.player;

import me.Hackusate_PvP.FateHub.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TogglePlayersCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (Main.getPlugin().getAPI().getSettingsManager().isPlayersVanished(player)) {
                Main.getPlugin().getAPI().getSettingsManager().setPlayersVanished(player, false);
                player.sendMessage(ChatColor.GREEN + "You can now see players");
            } else {
                Main.getPlugin().getAPI().getSettingsManager().setPlayersVanished(player, true);
                player.sendMessage(ChatColor.RED + "Players are now hidden.");
            }
        } else {
            sender.sendMessage(ChatColor.DARK_RED + "You must be a player.");
        }
        return false;
    }
}
