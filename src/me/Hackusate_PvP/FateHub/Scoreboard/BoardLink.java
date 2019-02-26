package me.Hackusate_PvP.FateHub.Scoreboard;

import io.github.thatkawaiisam.assemble.AssembleAdapter;
import me.Hackusate_PvP.FateHub.API;
import me.Hackusate_PvP.FateHub.Main;
import me.signatured.ezqueuespigot.EzQueueAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class BoardLink implements AssembleAdapter {


    @Override
    public String getTitle(Player player) {
        return ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getAPI().getScoreboardConfig().getConfig().getString("Board.Title"));
    }

    @Override
    public List<String> getLines(Player player) {
        API api = Main.getPlugin().getAPI();
        final List<String> toReturn = new ArrayList<>();
        if (api.getSettingsManager().hasBoard(player)) {
            if (api.getManager().isRegister(player)) {
                return getFormatLines(api.getScoreboardConfig().getConfig().getStringList("Board.Type.Register"), player);
            }
            if (api.getManager().isLogin(player)) {
                return getFormatLines(api.getScoreboardConfig().getConfig().getStringList("Board.Type.Login"), player);
            }
            if (EzQueueAPI.getQueue(player.getUniqueId()) != null) {
                return getFormatLines(api.getScoreboardConfig().getConfig().getStringList("Board.Type.Queue"), player);
            } else {
                return getFormatLines(api.getScoreboardConfig().getConfig().getStringList("Board.Type.Hub"), player);
            }
        }
        return null;
    }

    private List<String> getFormatLines(List<String> strings, Player player) {
        List<String> toReturn = new ArrayList<String>();

        for (String string : strings) {
            string = ChatColor.translateAlternateColorCodes('&', string);
            string = string.replace("%PLAYER%", player.getName() + "");
            if (EzQueueAPI.getQueue(player) != null) {
                string = string.replace("%QUEUE%", EzQueueAPI.getQueue(player.getUniqueId()) + "");
                string = string.replace("%POSITION%", EzQueueAPI.getPosition(player.getUniqueId()) + "");
                string = string.replace("%PLAYERSINQUEUE%", EzQueueAPI.getPlayersInQueue(EzQueueAPI.getQueue(player.getUniqueId())) + "");
            } else {
                string = string.replace("%QUEUE%: &c%POSITION%&f/&c%PLAYERSINQUEUE%", "");
            }
            string = string.replace("default", "master");
            string = string.replace("%RANK%", Main.getPermissions().getPrimaryGroup(player) + "");
            toReturn.add(string);
        }
        return toReturn;
    }

}
