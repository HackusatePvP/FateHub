package me.Hackusate_PvP.FateHub.Items;


import me.Hackusate_PvP.FateHub.Main;
import me.Hackusate_PvP.FateHub.Utils.CC;
import me.Hackusate_PvP.FateHub.Utils.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ItemManager {

    public ItemStack getEnderPeal(Player player) {
        return new ItemBuilder(Material.getMaterial(Main.getPlugin().getAPI().getItemConfig().getConfig().getString("Items.Enderpearl.Material")), 64)
                .setName(Main.getPlugin().getAPI().getCc().format(Main.getPlugin().getAPI().getItemConfig().getConfig().getString("Items.Enderpearl.Name")))
                .setLore(Main.getPlugin().getAPI().getCc().getFormatLines(Main.getPlugin().getAPI().getItemConfig().getConfig().getStringList("Items.Enderpearl.Lore"), player))
                .setInfinityDurability().addEnchant(Enchantment.getByName(Main.getPlugin().getAPI().getItemConfig().getConfig().getString("Items.Enderpearl.Enchantment.Type")),
                        Main.getPlugin().getAPI().getItemConfig().getConfig().getInt("Items.Enderpearl.Enchantment.Level")).toItemStack();
    }

    public ItemStack getCompass(Player player) {
        return new ItemBuilder(Material.getMaterial(Main.getPlugin().getAPI().getItemConfig().getConfig().getString("Items.Compass.Material")), 1)
                .setName(Main.getPlugin().getAPI().getCc().format(Main.getPlugin().getAPI().getItemConfig().getConfig().getString("Items.Compass.Name")))
                .setLore(Main.getPlugin().getAPI().getCc().getFormatLines(Main.getPlugin().getAPI().getItemConfig().getConfig().getStringList("Items.Compass.Lore"), player))
                .setInfinityDurability().addEnchant(Enchantment.getByName(Main.getPlugin().getAPI().getItemConfig().getConfig().getString("Items.Compass.Enchantment.Type")),
                        Main.getPlugin().getAPI().getItemConfig().getConfig().getInt("Items.Compass.Enchantment.Level")).toItemStack();
    }

    public ItemStack getSettings(Player player) {
        return new ItemBuilder(Material.getMaterial(Main.getPlugin().getAPI().getItemConfig().getConfig().getString("Items.Settings.Material")), 1)
                .setName(Main.getPlugin().getAPI().getCc().format(Main.getPlugin().getAPI().getItemConfig().getConfig().getString("Items.Settings.Name")))
                .setLore(Main.getPlugin().getAPI().getCc().getFormatLines(Main.getPlugin().getAPI().getItemConfig().getConfig().getStringList("Items.Settings.Lore"), player))
                .setInfinityDurability().addEnchant(Enchantment.getByName(Main.getPlugin().getAPI().getItemConfig().getConfig().getString("Items.Settings.Enchantment.Type")),
                        Main.getPlugin().getAPI().getItemConfig().getConfig().getInt("Items.Settings.Enchantment.Level")).toItemStack();
    }

    public ItemStack getCosmetics(Player player) {
        return new ItemBuilder(Material.getMaterial(Main.getPlugin().getAPI().getItemConfig().getConfig().getString("Items.Cosmetics.Material")), 1)
                .setName(Main.getPlugin().getAPI().getCc().format(Main.getPlugin().getAPI().getItemConfig().getConfig().getString("Items.Cosmetics.Name")))
                .setLore(Main.getPlugin().getAPI().getCc().getFormatLines(Main.getPlugin().getAPI().getItemConfig().getConfig().getStringList("Items.Cosmetics.Lore"), player))
                .setInfinityDurability().addEnchant(Enchantment.getByName(Main.getPlugin().getAPI().getItemConfig().getConfig().getString("Items.Cosmetics.Enchantment.Type")),
                        Main.getPlugin().getAPI().getItemConfig().getConfig().getInt("Items.Cosmetics.Enchantment.Level")).toItemStack();
    }


}
