package me.Hackusate_PvP.FateHub.Utils;

import me.Hackusate_PvP.FateHub.Main;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.Random;

public class Generator {

    public void genrateID(Player player) {
        Random id = new Random();
        int idfin = id.nextInt(9000) + 1000;
        Main.getPlugin().getAPI().getPlayerData().getConfig().set(player.getUniqueId() + ".id", idfin);
    }

    public Integer getID(Player player) {
        return Main.getPlugin().getAPI().getPlayerData().getConfig().getInt(player.getUniqueId() + ".id");
    }

    public Integer getID(OfflinePlayer player) {
        return Main.getPlugin().getAPI().getPlayerData().getConfig().getInt(player.getUniqueId() + ".id");
    }

}
