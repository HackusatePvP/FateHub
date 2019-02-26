package me.Hackusate_PvP.FateHub.Commands.staff;

import me.Hackusate_PvP.FateHub.Main;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InfoCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (sender.hasPermission("fatekits.staff")) {
                if (args.length == 0) {
                    player.openInventory(Main.getPlugin().getAPI().getInventoryManager().getInfoInventory(player));
                } else {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    final OfflinePlayer offplayer = Bukkit.getOfflinePlayer(args[0]);
                    if (target != null) {
                        player.openInventory(Main.getPlugin().getAPI().getInventoryManager().getInfoInventory(target));
                    } else {
                        player.openInventory(Main.getPlugin().getAPI().getInventoryManager().getInfoInventory(offplayer));
                    }
                }
            }
        } else {

        }
        return false;
    }
}
