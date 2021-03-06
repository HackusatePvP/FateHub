package me.Hackusate_PvP.FateHub.Tab;


import com.bizarrealex.azazel.tab.TabAdapter;
import com.bizarrealex.azazel.tab.TabTemplate;
import me.Hackusate_PvP.FateHub.API;
import me.Hackusate_PvP.FateHub.Main;
import me.clip.placeholderapi.PlaceholderAPI;
import me.signatured.ezqueuespigot.EzQueueAPI;
import org.bukkit.entity.Player;

public class TabLink implements TabAdapter {
    public TabTemplate getTemplate(Player player) {
        TabTemplate template = new TabTemplate();
        API api = Main.getPlugin().getAPI();
        if (Main.getPlugin().getAPI().getSettingsManager().isTablist(player)) {
            String kit = "%pinger_players_kitpvp%";
            String kitset = PlaceholderAPI.setPlaceholders(player.getPlayer(), kit);
            String hcf = "%pinger_players_hcf%";
            String hcfset = PlaceholderAPI.setPlaceholders(player.getPlayer(), hcf);
            template.left(0, "&4&lServer Info");
            template.left(1, "");
            template.left(2, "&9&lKitPvP &c&lInfo");
            template.left(3, "&b&lOnline: &7" + kitset);
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
            template.left(7, "&9&lHCF &c&lInfo");
            template.left(8, "&b&lOnline: &7" + hcfset);
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
            template.middle(2, "&9&lGeneral &c&lInfo");
            template.middle(3, "&b&lName");
            template.middle(4, "&7" + player.getName());
            template.middle(5, "&b&lRank");
            if (Main.getPermissions().getPrimaryGroup(player).equalsIgnoreCase("Fate")) {
                template.middle(6, "&4" + Main.getPermissions().getPrimaryGroup(player));
            } else if (Main.getPermissions().getPrimaryGroup(player).equalsIgnoreCase("Saber")) {
                template.middle(6, "&9" + Main.getPermissions().getPrimaryGroup(player));
            } else if (Main.getPermissions().getPrimaryGroup(player).equalsIgnoreCase("Berserker")) {
                template.middle(6, "&6" + Main.getPermissions().getPrimaryGroup(player));
            } else if (Main.getPermissions().getPrimaryGroup(player).equalsIgnoreCase("Lancer")) {
                template.middle(6, "&5" + Main.getPermissions().getPrimaryGroup(player));
            } else if (Main.getPermissions().getPrimaryGroup(player).equalsIgnoreCase("Assassin")) {
                template.middle(6, "&1" + Main.getPermissions().getPrimaryGroup(player));
            } else if (Main.getPermissions().getPrimaryGroup(player).equalsIgnoreCase("Archer")) {
                template.middle(6, "&e" + Main.getPermissions().getPrimaryGroup(player));
            } else if (Main.getPermissions().getPrimaryGroup(player).equalsIgnoreCase("Caster")) {
                template.middle(6, "&d" + Main.getPermissions().getPrimaryGroup(player));
            } else if (Main.getPermissions().getPrimaryGroup(player).equalsIgnoreCase("Rider")) {
                template.middle(6, "&a" + Main.getPermissions().getPrimaryGroup(player));
            } else {
                template.middle(6, "&f&lMaster");
            }
            template.middle(7, "");
            template.middle(8, "&9&lSettings &c&lInfo");
            if (Main.getPlugin().getAPI().getSettingsManager().isTablist(player)) {
                template.middle(9, "&bTablist: &a" + Main.getPlugin().getAPI().getSettingsManager().isTablist(player) + "");
            } else {
                template.middle(9, "&bTablist: &c" + Main.getPlugin().getAPI().getSettingsManager().isTablist(player) + "");
            }
            if (Main.getPlugin().getAPI().getSettingsManager().hasBoard(player)) {
                template.middle(10, "&bScoreboard: &a" + Main.getPlugin().getAPI().getSettingsManager().hasBoard(player) + "");
            } else {
                template.middle(10, "&bScoreboard: &c" + Main.getPlugin().getAPI().getSettingsManager().hasBoard(player) + "");
            }
            if (Main.getPlugin().getAPI().getSettingsManager().isPlayersVanished(player)) {
                template.middle(11, "&bVisibility: &a" + Main.getPlugin().getAPI().getSettingsManager().isPlayersVanished(player) + "");
            } else {
                template.middle(11, "&bVisibility: &c" + Main.getPlugin().getAPI().getSettingsManager().isPlayersVanished(player) + "");
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
