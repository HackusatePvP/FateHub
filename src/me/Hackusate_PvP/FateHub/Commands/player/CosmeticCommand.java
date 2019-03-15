package me.Hackusate_PvP.FateHub.Commands.player;

import me.Hackusate_PvP.FateHub.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CosmeticCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.openInventory(Main.getPlugin().getAPI().getInventoryManager().getCosmeticsInventory(player));
        } else {

        }
        return false;
    }
}
