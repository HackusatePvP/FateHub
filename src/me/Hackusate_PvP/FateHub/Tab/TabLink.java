package me.Hackusate_PvP.FateHub.Tab;


import com.bizarrealex.azazel.tab.TabAdapter;
import com.bizarrealex.azazel.tab.TabTemplate;
import me.Hackusate_PvP.FateHub.API;
import me.Hackusate_PvP.FateHub.Main;
import me.signatured.ezqueuespigot.EzQueueAPI;
import org.bukkit.entity.Player;

public class TabLink implements TabAdapter {
    public TabTemplate getTemplate(Player player) {
        TabTemplate template = new TabTemplate();
        API api = Main.getPlugin().getAPI();
        if (Main.getPlugin().getAPI().getSettingsManager().isTablist(player)) {
            template.left(0, "&4&lServer Info");
            template.left(1, "");
            template.left(2, "&9&lKitPvP Info");
            template.left(3, "&b&lOnline: &7"); //TODO GET PLACEHOLDER
            if (api.getServerData().getConfig().getString("KitPvP.Status").equalsIgnoreCase("Offline")) {
                template.left(4, "&b&lStatus: &cOffline");
            } else if (api.getServerData().getConfig().getString("KitPvP.Status").equalsIgnoreCase("Whitelist")) {
                template.left(4, "&b&lStatus: &fWhitelisted");
            } else {
                template.left(4, "&b&lStatus: &aOnline");
            }
            if (EzQueueAPI.getPlayersInQueue("kitpvp") != null && api.getServerData().getConfig().getString("KitPvP.Online").equalsIgnoreCase("Offline")) {
                template.left(5, "&b&lQueue: &7" + EzQueueAPI.getPlayersInQueue("kitpvp"));
            } else if (EzQueueAPI.getPlayersInQueue("kitpvp") != null && api.getServerData().getConfig().getString("KitPvP.Online").equalsIgnoreCase("Whitelist")) {
                template.left(5, "&b&lQueue: &fWhitelisted");
            } else {
                template.left(5, "&b&lQueue: &cOffline");
            }
        /*if (EzQueueAPI.getQueue(player).equalsIgnoreCase("kitpvp")) {
            template.left(5, "&b&lQueue: &7" + EzQueueAPI.getPosition(player) + "&f/" + EzQueueAPI.getPlayersInQueue("kitpvp"));
        } else {
            template.left(5, "&b&lQueue: &7" + EzQueueAPI.getPlayersInQueue("kitpvp"));
        } */
            template.left(6, "");
            template.left(7, "&9&lHCF Info");
            template.left(8, "&b&lOnline: &7"); //TODO GET ONLINE
            if (api.getServerData().getConfig().getString("HCF.Status").equalsIgnoreCase("Offline")) {
                template.left(9, "&b&lStatus: &cOffline");
            } else if (api.getServerData().getConfig().getString("HCF.Status").equalsIgnoreCase("Whitelist")) {
                template.left(9, "&b&lStatus: &fWhitelisted");
            } else {
                template.left(9, "&b&lStatus: &aOnline");
            }
            if (EzQueueAPI.getPlayersInQueue("hcf") != null && api.getServerData().getConfig().getString("HCF.Online").equalsIgnoreCase("Offline")) {
                template.left(10, "&b&lQueue: &7" + EzQueueAPI.getPlayersInQueue("hcf"));
            } else if (EzQueueAPI.getPlayersInQueue("hcf") != null && api.getServerData().getConfig().getString("HCF.Online").equalsIgnoreCase("Whitelist")) {
                template.left(10, "&b&lQueue: &fWhitelisted");
            } else {
                template.left(10, "&b&lQueue: &cOffline");
            }

            template.left(19, "");

            template.middle("&4&lPlayer Info");
            template.middle(1, "");
            template.middle(2, "&b&lName");
            template.middle(3, "&7" + player.getName());
            template.middle(4, "&b&lRank");
            if (Main.getPermissions().getPrimaryGroup(player).equalsIgnoreCase("Fate")) {
                template.middle(5, "&4" + Main.getPermissions().getPrimaryGroup(player));
            } else if (Main.getPermissions().getPrimaryGroup(player).equalsIgnoreCase("Saber")) {
                template.middle(5, "&9" + Main.getPermissions().getPrimaryGroup(player));
            } else if (Main.getPermissions().getPrimaryGroup(player).equalsIgnoreCase("Berserker")) {
                template.middle(5, "&6" + Main.getPermissions().getPrimaryGroup(player));
            } else if (Main.getPermissions().getPrimaryGroup(player).equalsIgnoreCase("Lancer")) {
                template.middle(5, "&5" + Main.getPermissions().getPrimaryGroup(player));
            } else if (Main.getPermissions().getPrimaryGroup(player).equalsIgnoreCase("Assassin")) {
                template.middle(5, "&1" + Main.getPermissions().getPrimaryGroup(player));
            } else if (Main.getPermissions().getPrimaryGroup(player).equalsIgnoreCase("Archer")) {
                template.middle(5, "&e" + Main.getPermissions().getPrimaryGroup(player));
            } else if (Main.getPermissions().getPrimaryGroup(player).equalsIgnoreCase("Caster")) {
                template.middle(5, "&d" + Main.getPermissions().getPrimaryGroup(player));
            } else if (Main.getPermissions().getPrimaryGroup(player).equalsIgnoreCase("Rider")) {
                template.middle(5, "&a" + Main.getPermissions().getPrimaryGroup(player));
            } else {
                template.middle(5, "&f&lMaster");
            }
            template.middle(6, "");
            template.middle(7, "&9&lSettings Info");
            if (Main.getPlugin().getAPI().getSettingsManager().isTablist(player)) {
                template.middle(8, "&bTablist: &a" + Main.getPlugin().getAPI().getSettingsManager().isTablist(player) + "");
            } else {
                template.middle(8, "&bTablist: &c" + Main.getPlugin().getAPI().getSettingsManager().isTablist(player) + "");
            }
            if (Main.getPlugin().getAPI().getSettingsManager().hasBoard(player)) {
                template.middle(9, "&bScoreboard: &a" + Main.getPlugin().getAPI().getSettingsManager().hasBoard(player) + "");
            } else {
                template.middle(9, "&bScoreboard: &c" + Main.getPlugin().getAPI().getSettingsManager().hasBoard(player) + "");
            }
            if (Main.getPlugin().getAPI().getSettingsManager().isPlayersVanished(player)) {
                template.middle(10, "&bVisibility: &a" + Main.getPlugin().getAPI().getSettingsManager().isPlayersVanished(player) + "");
            } else {
                template.middle(10, "&bVisibility: &c" + Main.getPlugin().getAPI().getSettingsManager().isPlayersVanished(player) + "");
            }
            template.middle(19, "");

            template.right("&4&lRank List");
            template.right(1, "");
            template.right(2, "&c&l#1: &3Fate");
            template.right(3, "&c&l#2: &3Saber");
            template.right(4, "&c&l#3: &3Berserker");
            template.right(5, "&c&l#4: &3Lancer");
            template.right(6, "&c&l#5: &3Assassin");
            template.right(7, "&c&l#6: &3Archer");
            template.right(8, "&c&l#7: &3Caster");
            template.right(9, "&c&l#8: &3Rider");
            template.right(19, "");

            return template;
        }

        return null;
    }
}
