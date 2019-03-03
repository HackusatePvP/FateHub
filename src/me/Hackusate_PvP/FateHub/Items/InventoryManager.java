package me.Hackusate_PvP.FateHub.Items;

import me.Hackusate_PvP.FateHub.Main;
import me.Hackusate_PvP.FateHub.Utils.ItemBuilder;
import me.signatured.ezqueuespigot.EzQueueAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager {

    public Inventory getServerInventory(Player player) {
        Inventory i = Bukkit.createInventory(null, 27, Main.getPlugin().getAPI().getCc().format("&9&lServer &4&lSelector"));

        i.setItem(11, getServers("hcf", player));
        i.setItem(12, getServers("kitpvp", player));
        return i;
    }

    public Inventory getStatusInventory(Player player) {
        Inventory i = Bukkit.createInventory(null, 9, Main.getPlugin().getAPI().getCc().format("&9&lStatus Configuration"));

        i.setItem(0, getStatus("kitpvp", player));
        i.setItem(1, getStatus("hcf", player));

        return i;
    }

    public Inventory getInfoInventory(Player player) {
        Inventory i = Bukkit.createInventory(null, 9, Main.getPlugin().getAPI().getCc().format("&9&l" + player.getName() + "'s Info"));

        i.setItem(4, getInfo(player));
        return i;
    }
    public Inventory getInfoInventory(OfflinePlayer player) {
        Inventory i = Bukkit.createInventory(null, 9, Main.getPlugin().getAPI().getCc().format("&9&l" + player.getName() + "'s Info"));

        i.setItem(4, getInfo(player));
        return i;
    }

    public Inventory getCosmeticsInventory(Player player) {
        Inventory i = Bukkit.createInventory(null, 9, Main.getPlugin().getAPI().getCc().format("&9&lCosmetic Items"));

        i.setItem(0, getCosmetics("test", player));
        i.setItem(1, getCosmetics("fly", player));
        i.setItem(2, getCosmetics("adventure", player));
        i.setItem(3, getCosmetics("pop", player));
        return i;
    }

    public Inventory getSettingsInventory(Player player) {
        Inventory i = Bukkit.createInventory(null, 9, Main.getPlugin().getAPI().getCc().format("&9&lSettings Configuration"));

        i.setItem(0, getSettings("tablist", player));
        i.setItem(1, getSettings("scoreboard", player));
        i.setItem(2, getSettings("pvanish", player));
        i.setItem(3, getSettings("doublejump", player));
        i.setItem(4, getSettings("chat", player));
        return i;
    }

    public ItemStack getCosmetics(String cosmetics, Player player) {
        if (cosmetics.equals("test")) {
            ItemStack is = new ItemBuilder(Material.getMaterial(Main.getPlugin().getAPI().getCosmeticConfig().getConfig().getString("Test.Material")), 1)
                    .setName(Main.getPlugin().getAPI().getCc().format(Main.getPlugin().getAPI().getCosmeticConfig().getConfig().getString("Test.Name")))
                    .setLore(Main.getPlugin().getAPI().getCc().getFormatLines(Main.getPlugin().getAPI().getCosmeticConfig().getConfig().getStringList("Test.Lore"), player))
                    .toItemStack();
            return is;
        }
            if (cosmetics.equals("fly")) {
            ItemStack is = new ItemBuilder(Material.getMaterial(Main.getPlugin().getAPI().getCosmeticConfig().getConfig().getString("Fly.Material")), 1)
                    .setName(Main.getPlugin().getAPI().getCc().format(Main.getPlugin().getAPI().getCosmeticConfig().getConfig().getString("Fly.Name")))
                    .setLore(Main.getPlugin().getAPI().getCc().getFormatLines(Main.getPlugin().getAPI().getCosmeticConfig().getConfig().getStringList("Fly.Lore"), player))
                    .toItemStack();
            return is;
        }
        if (cosmetics.equals("adventure")) {
            ItemStack is = new ItemBuilder(Material.getMaterial(Main.getPlugin().getAPI().getCosmeticConfig().getConfig().getString("Adventure.Material")), 1)
                    .setName(Main.getPlugin().getAPI().getCc().format(Main.getPlugin().getAPI().getCosmeticConfig().getConfig().getString("Adventure.Name")))
                    .setLore(Main.getPlugin().getAPI().getCc().getFormatLines(Main.getPlugin().getAPI().getCosmeticConfig().getConfig().getStringList("Adventure.Lore"), player))
                    .toItemStack();
            return is;
        }
        if (cosmetics.equals("pop")) {
            ItemStack is = new ItemBuilder(Material.getMaterial(Main.getPlugin().getAPI().getCosmeticConfig().getConfig().getString("PlayerPop.Material")), 1)
                    .setName(Main.getPlugin().getAPI().getCc().format(Main.getPlugin().getAPI().getCosmeticConfig().getConfig().getString("PlayerPop.Name")))
                    .setLore(Main.getPlugin().getAPI().getCc().getFormatLines(Main.getPlugin().getAPI().getCosmeticConfig().getConfig().getStringList("PlayerPop.Lore"), player))
                    .toItemStack();
            return is;
        }

        return null;
    }

    public ItemStack getInfo(Player player) {
        return new ItemBuilder(Material.STONE, 1)
                .setName(Main.getPlugin().getAPI().getCc().format("&9&l" + player.getName()))
                .setLore(Main.getPlugin().getAPI().getCc().getFormatLines(Main.getPlugin().getAPI().getInfoConfig().getConfig().getStringList("Player.Lore"), player))
                .setSkullOwner(player.getName()).toItemStack();
    }
    public ItemStack getInfo(OfflinePlayer player) {
        return new ItemBuilder(Material.STONE, 1)
                .setName(Main.getPlugin().getAPI().getCc().format("&9&l" + player.getName()))
                .setLore(Main.getPlugin().getAPI().getCc().getFormatLines(Main.getPlugin().getAPI().getInfoConfig().getConfig().getStringList("Player.Lore"), player))
                .setSkullOwner(player.getName()).toItemStack();
    }

    public ItemStack getStatus(String server, Player player) {
        if (server.equalsIgnoreCase("hcf")) {
            ItemStack is = new ItemBuilder(Material.getMaterial(Main.getPlugin().getAPI().getStatusConfig().getConfig().getString("HCF.Material")), 1)
                    .setName(Main.getPlugin().getAPI().getCc().format(Main.getPlugin().getAPI().getStatusConfig().getConfig().getString("HCF.Name")))
                    .setLore(Main.getPlugin().getAPI().getCc().getFormatLines(Main.getPlugin().getAPI().getStatusConfig().getConfig().getStringList("HCF.Lore"), player))
                    .toItemStack();
            return is;
        }
        if (server.equalsIgnoreCase("kitpvp")) {
            ItemStack is = new ItemBuilder(Material.getMaterial(Main.getPlugin().getAPI().getStatusConfig().getConfig().getString("KitPvP.Material")), 1)
                    .setName(Main.getPlugin().getAPI().getCc().format(Main.getPlugin().getAPI().getStatusConfig().getConfig().getString("KitPvP.Name")))
                    .setLore(Main.getPlugin().getAPI().getCc().getFormatLines(Main.getPlugin().getAPI().getStatusConfig().getConfig().getStringList("KitPvP.Lore"), player))
                    .toItemStack();
            return is;
        }

        return null;
    }

    public ItemStack getSettings(String settings, Player player) {
        if (settings.equals("tablist")) {
            ItemStack is = new ItemBuilder(Material.getMaterial(Main.getPlugin().getAPI().getMessageConfig().getConfig().getString("Tablist.Material")), 1)
                    .setName(Main.getPlugin().getAPI().getCc().format(Main.getPlugin().getAPI().getMessageConfig().getConfig().getString("Tablist.Name")))
                    .setLore(Main.getPlugin().getAPI().getCc().getFormatLines(Main.getPlugin().getAPI().getMessageConfig().getConfig().getStringList("Tablist.Lore"), player))
                    .toItemStack();
            return is;
        }
        if (settings.equals("scoreboard")) {
            ItemStack is = new ItemBuilder(Material.getMaterial(Main.getPlugin().getAPI().getMessageConfig().getConfig().getString("Scoreboard.Material")), 1)
                    .setName(Main.getPlugin().getAPI().getCc().format(Main.getPlugin().getAPI().getMessageConfig().getConfig().getString("Scoreboard.Name")))
                    .setLore(Main.getPlugin().getAPI().getCc().getFormatLines(Main.getPlugin().getAPI().getMessageConfig().getConfig().getStringList("Scoreboard.Lore"), player))
                    .toItemStack();
            return is;
        }
        if (settings.equals("pvanish")) {
            ItemStack is = new ItemBuilder(Material.getMaterial(Main.getPlugin().getAPI().getMessageConfig().getConfig().getString("Vanish.Material")), 1)
                    .setName(Main.getPlugin().getAPI().getCc().format(Main.getPlugin().getAPI().getMessageConfig().getConfig().getString("Vanish.Name")))
                    .setLore(Main.getPlugin().getAPI().getCc().getFormatLines(Main.getPlugin().getAPI().getMessageConfig().getConfig().getStringList("Vanish.Lore"), player))
                    .toItemStack();
            return is;
        }
        if (settings.equals("doublejump")) {
            ItemStack is = new ItemBuilder(Material.getMaterial(Main.getPlugin().getAPI().getMessageConfig().getConfig().getString("DJ.Material")), 1)
                    .setName(Main.getPlugin().getAPI().getCc().format(Main.getPlugin().getAPI().getMessageConfig().getConfig().getString("DJ.Name")))
                    .setLore(Main.getPlugin().getAPI().getCc().getFormatLines(Main.getPlugin().getAPI().getMessageConfig().getConfig().getStringList("DJ.Lore"), player))
                    .toItemStack();
            return is;
        }
        if (settings.equals("chat")) {
            ItemStack is = new ItemBuilder(Material.getMaterial(Main.getPlugin().getAPI().getMessageConfig().getConfig().getString("Chat.Material")), 1)
                    .setName(Main.getPlugin().getAPI().getCc().format(Main.getPlugin().getAPI().getMessageConfig().getConfig().getString("Chat.Name")))
                    .setLore(Main.getPlugin().getAPI().getCc().getFormatLines(Main.getPlugin().getAPI().getMessageConfig().getConfig().getStringList("Chat.Lore"), player))
                    .toItemStack();
            return is;
        }

        return null;
    }

    public ItemStack getServers(String server, Player player) {
        if (server.equalsIgnoreCase("hcf")) {
            ItemStack is = new ItemBuilder(Material.getMaterial(Main.getPlugin().getAPI().getServerData().getConfig().getString("HCF.Material")), 1)
                    .setName(Main.getPlugin().getAPI().getCc().format(Main.getPlugin().getAPI().getServerData().getConfig().getString("HCF.Name")))
                    .setLore(Main.getPlugin().getAPI().getCc().getFormatLines(Main.getPlugin().getAPI().getServerData().getConfig().getStringList("HCF.Lore"), player))
                    .addEnchant(Enchantment.getByName(Main.getPlugin().getAPI().getServerData().getConfig().getString("HCF.Enchantment.Type")),
                            Main.getPlugin().getAPI().getServerData().getConfig().getInt("HCF.Enchantment.Level")).setDurability((short) 0).toItemStack();
            return is;
        }
        if (server.equalsIgnoreCase("kitpvp")) {
            return new ItemBuilder(Material.getMaterial(Main.getPlugin().getAPI().getServerData().getConfig().getString("KitPvP.Material")), 1)
                    .setName(Main.getPlugin().getAPI().getCc().format(Main.getPlugin().getAPI().getServerData().getConfig().getString("KitPvP.Name")))
                    .setLore(Main.getPlugin().getAPI().getCc().getFormatLines(Main.getPlugin().getAPI().getServerData().getConfig().getStringList("KitPvP.Lore"), player))
                    .addEnchant(Enchantment.getByName(Main.getPlugin().getAPI().getServerData().getConfig().getString("KitPvP.Enchantment.Type")),
                            Main.getPlugin().getAPI().getServerData().getConfig().getInt("KitPvP.Enchantment.Level")).setDurability((short) 0).toItemStack();
        }
        return null;
    }

    private List<String> getFormatLines(List<String> strings, Player player) {
        List<String> toReturn = new ArrayList<String>();

        for (String string : strings) {
            string = ChatColor.translateAlternateColorCodes('&', string);
            string = string.replace("%PLAYER%", player.getName() + "");
            string = string.replace("%POSITION%", EzQueueAPI.getPosition(player.getUniqueId()) + "");
            string = string.replace("%PLAYERSINQUEUE%", EzQueueAPI.getPlayersInQueue(EzQueueAPI.getQueue(player.getUniqueId())) + "");
            toReturn.add(string);
        }
        return toReturn;
    }
}
