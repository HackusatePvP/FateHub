package me.Hackusate_PvP.FateHub.Profiles;

import me.Hackusate_PvP.FateHub.Main;
import org.bukkit.entity.Player;

public class SettingsManager {

    public boolean hasBoard(Player player) {
        return Main.getPlugin().getAPI().getPlayerData().getConfig().getBoolean(player.getUniqueId() + ".scoreboard");
    }

    public void setBoard(Player player, boolean status) {
        Main.getPlugin().getAPI().getPlayerData().getConfig().set(player.getUniqueId() + ".scoreboard", status);
    }

    public boolean isPlayersVanished(Player player) {
        return Main.getPlugin().getAPI().getPlayerData().getConfig().getBoolean(player.getUniqueId() + ".pvanish");
    }

    public void setPlayersVanished(Player player, boolean status) {
        Main.getPlugin().getAPI().getPlayerData().getConfig().set(player.getUniqueId() + ".pvanish", status);
    }

    public boolean isTablist(Player player) {
        return Main.getPlugin().getAPI().getPlayerData().getConfig().getBoolean(player.getUniqueId() + ".tablist");
    }

    public void setTablist(Player player, boolean status) {
        Main.getPlugin().getAPI().getPlayerData().getConfig().set(player.getUniqueId() + ".tablist", status);
    }

    public boolean hasDoubleJump(Player player) {
        return Main.getPlugin().getAPI().getPlayerData().getConfig().getBoolean(player.getUniqueId() + ".doublejump");
    }

    public void setDoubleJump(Player player, boolean status) {
        Main.getPlugin().getAPI().getPlayerData().getConfig().set(player.getUniqueId() + ".doublejump", status);
    }

}
