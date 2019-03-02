package me.Hackusate_PvP.FateHub.Commands.player;

import me.Hackusate_PvP.FateHub.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CreativeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                player.setGameMode(GameMode.CREATIVE);
            } else {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (target != null) {
                    player.sendMessage(Main.getPlugin().getAPI().getCc().format("&bYou have updated &c&l" + target.getName() + "'s &bGAMEMODE."));
                    target.setGameMode(GameMode.CREATIVE);
                } else {
                    player.sendMessage(ChatColor.RED + "Player with name not found.");
                }
            }
        } else {
            sender.sendMessage(ChatColor.DARK_RED + "You must be a player.");
        }
        return false;
    }
}
