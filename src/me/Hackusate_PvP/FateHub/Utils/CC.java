package me.Hackusate_PvP.FateHub.Utils;

import me.Hackusate_PvP.FateHub.Main;
import me.signatured.ezqueuespigot.EzQueueAPI;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CC {

    public String format(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public List<String> getFormatLines(List<String> strings, Player player) {
        List<String> toReturn = new ArrayList<String>();

        for (String string : strings) {
            string = ChatColor.translateAlternateColorCodes('&', string);
            if (EzQueueAPI.getQueue(player) != null) {
                string = string.replace("%kitpvpplayersinqueue%", EzQueueAPI.getPlayersInQueue("kitpvp") + "");
                string = string.replace("%hcfplayersinqueue%", EzQueueAPI.getPlayersInQueue("hcf") + "");
            } else {
                string = string.replace("%kitpvpplayersinqueue%", "Offline");
                string = string.replace("%hcfplayersinqueue%", "Offline");
            }
            string = string.replace("%hcfmaxplayers%", Main.getPlugin().getAPI().getServerData().getConfig().getInt("HCF.MaxPlayers") + "");
            string = string.replace("%kitpvpmaxplayers%", Main.getPlugin().getAPI().getServerData().getConfig().getInt("KitPvP.MaxPlayers") + "");
            string = string.replace("%online%", 0 + "");
            string = string.replace("%tabstatus%", Main.getPlugin().getAPI().getPlayerData().getConfig().getBoolean(player.getUniqueId() + ".tablist") + "");
            string = string.replace("%sstatus%", Main.getPlugin().getAPI().getPlayerData().getConfig().getBoolean(player.getUniqueId() + ".scoreboard") + "");
            string = string.replace("%vanstatus%", Main.getPlugin().getAPI().getPlayerData().getConfig().getBoolean(player.getUniqueId() + ".pvanish") + "");
            string = string.replace("%djsatus%", Main.getPlugin().getAPI().getPlayerData().getConfig().getBoolean(player.getUniqueId() + ".doublejump") + "");
            string = string.replace("%cstatus%", Main.getPlugin().getAPI().getPlayerData().getConfig().getBoolean(player.getUniqueId() + ".chat") + "");
            string = string.replace("%kitstatus%", Main.getPlugin().getAPI().getServerData().getConfig().getString("KitPvP.Status") + "");
            string = string.replace("%hcfstatus%", Main.getPlugin().getAPI().getServerData().getConfig().getString("HCF.Status") + "");
            string = string.replace("%NAME%", player.getName() + "");
            string = string.replace("%ID%", Main.getPlugin().getAPI().getGenerator().getID(player) + "");
            string = string.replace("%RANK%", Main.getPermissions().getPrimaryGroup(player) + "");
            string = string.replace("%NAME%", player.getAddress().getHostString() + "");
            string = string.replace("%UUID%",player.getUniqueId() + "");
            string = string.replace("%BLACKLIST%", Main.getPlugin().getAPI().getPlayerData().getConfig().getBoolean(player.getUniqueId() + ".blacklist") + "");
            toReturn.add(string);
        }

        return toReturn;
    }

    public List<String> getFormatLines(List<String> strings, OfflinePlayer player) {
        List<String> toReturn = new ArrayList<String>();

        for (String string : strings) {
            string = ChatColor.translateAlternateColorCodes('&', string);
            string = string.replace("%NAME%", player.getName() + "");
            string = string.replace("%ID%", Main.getPlugin().getAPI().getGenerator().getID(player) + "");
            string = string.replace("%RANK%", Main.getPermissions().getPrimaryGroup("world", player) + "");
            string = string.replace("%NAME%", Main.getPlugin().getAPI().getPlayerData().getConfig().getString(player.getUniqueId() + ".ip") + "");
            string = string.replace("%UUID%",player.getUniqueId() + "");
            string = string.replace("%BLACKLIST%", Main.getPlugin().getAPI().getPlayerData().getConfig().getBoolean(player.getUniqueId() + ".blacklist") + "");
            toReturn.add(string);
        }

        return toReturn;
    }
}
