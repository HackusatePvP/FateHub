package me.Hackusate_PvP.FateHub.Rank;

import me.Hackusate_PvP.FateHub.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class RankManager {

    public String getRank(Player player) {
        if (Main.getPermissions().getPrimaryGroup(player).equalsIgnoreCase("fate")) {
            return Main.getPlugin().getAPI().getCc().format("&4&lFate");
        }
        if (Main.getPermissions().getPrimaryGroup(player).equalsIgnoreCase("saber")) {
            return Main.getPlugin().getAPI().getCc().format("&9&lSaber");
        }
        if (Main.getPermissions().getPrimaryGroup(player).equalsIgnoreCase("berserker")) {
            return Main.getPlugin().getAPI().getCc().format("&6&lBerserker");
        }
        if (Main.getPermissions().getPrimaryGroup(player).equalsIgnoreCase("lancer")) {
            return Main.getPlugin().getAPI().getCc().format("&5&lLancer");
        }
        if (Main.getPermissions().getPrimaryGroup(player).equalsIgnoreCase("assassin")) {
            return Main.getPlugin().getAPI().getCc().format("&1&lAssassin");
        }
        if (Main.getPermissions().getPrimaryGroup(player).equalsIgnoreCase("archer")) {
            return Main.getPlugin().getAPI().getCc().format("&e&lArcher");
        }
        if (Main.getPermissions().getPrimaryGroup(player).equalsIgnoreCase("caster")) {
            return Main.getPlugin().getAPI().getCc().format("&d&lCaster");
        }
        if (Main.getPermissions().getPrimaryGroup(player).equalsIgnoreCase("rider")) {
            return Main.getPlugin().getAPI().getCc().format("&a&lRider");
        }

        return Main.getPlugin().getAPI().getCc().format("&f&lMaster");
    }

    public void setRank(Player player, String rank) {
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex user" + player.getName() + " group set " + rank);
    }
}
