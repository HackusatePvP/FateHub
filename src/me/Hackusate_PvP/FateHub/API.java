package me.Hackusate_PvP.FateHub;

import lombok.Getter;
import me.Hackusate_PvP.FateHub.Files.*;
import me.Hackusate_PvP.FateHub.Items.InventoryManager;
import me.Hackusate_PvP.FateHub.Items.ItemManager;
import me.Hackusate_PvP.FateHub.Profiles.ProfileManager;
import me.Hackusate_PvP.FateHub.Profiles.SettingsManager;
import me.Hackusate_PvP.FateHub.Utils.CC;
import org.bukkit.Bukkit;

@Getter
public class API {
    public RegistryData registryData;
    public PlayerData playerData;
    public ProfileManager manager;
    public SettingsManager settingsManager;
    public ScoreboardConfig scoreboardConfig;
    public ItemConfig itemConfig;
    public ServerData serverData;
    public MessageConfig messageConfig;
    public StatusConfig statusConfig;
    public CosmeticConfig cosmeticConfig;
    public InfoConfig infoConfig;
    public ItemManager itemManager;
    public InventoryManager inventoryManager;
    public CC cc;

    public void registerConfigs() {
        Bukkit.getLogger().info("[FateHub] Loading registry_data.yml");
        this.registryData = new RegistryData(Main.getPlugin(), "registry_data.yml");
        this.registryData.saveConfig();
        this.registryData.getConfig().options().copyDefaults(true);
        this.registryData.saveConfig();
        this.registryData.reloadConfig();
        Bukkit.getLogger().info("[FateHub] Loading player_data.yml");
        this.playerData = new PlayerData(Main.getPlugin(), "player_data.yml");
        this.playerData.saveConfig();
        this.playerData.getConfig().options().copyDefaults(true);
        this.playerData.saveConfig();
        this.playerData.reloadConfig();
        Bukkit.getLogger().info("[FateHub] Loading scoreboard.yml");
        this.scoreboardConfig = new ScoreboardConfig(Main.getPlugin(), "scoreboard.yml");
        this.scoreboardConfig.saveConfig();
        this.scoreboardConfig.getConfig().options().copyDefaults(true);
        this.scoreboardConfig.saveConfig();
        this.scoreboardConfig.reloadConfig();
        Bukkit.getLogger().info("[FateHub] Loading items.yml");
        this.itemConfig = new ItemConfig(Main.getPlugin(), "items.yml");
        this.itemConfig.saveConfig();
        this.itemConfig.getConfig().options().copyDefaults(true);
        this.itemConfig.saveConfig();
        this.itemConfig.reloadConfig();
        Bukkit.getLogger().info("[FateHub] Loading server_dara.yml");
        this.serverData = new ServerData(Main.getPlugin(), "server_data.yml");
        this.serverData.saveConfig();
        this.serverData.getConfig().options().copyDefaults(true);
        this.serverData.saveConfig();
        this.serverData.reloadConfig();
        Bukkit.getLogger().info("[FateHub] Loading settings.yml");
        this.messageConfig = new MessageConfig(Main.getPlugin(), "settings.yml");
        this.messageConfig.saveConfig();
        this.messageConfig.getConfig().options().copyDefaults(true);
        this.messageConfig.saveConfig();
        this.messageConfig.reloadConfig();
        Bukkit.getLogger().info("[FateHub] Loading status.yml");
        this.statusConfig = new StatusConfig(Main.getPlugin(), "status.yml");
        this.statusConfig.saveConfig();
        this.statusConfig.getConfig().options().copyDefaults(true);
        this.statusConfig.saveConfig();
        this.statusConfig.reloadConfig();
        Bukkit.getLogger().info("[FateHub] Loading cosmetic.yml");
        this.cosmeticConfig = new CosmeticConfig(Main.getPlugin(), "cosmetic.yml");
        this.cosmeticConfig.saveConfig();
        this.cosmeticConfig.getConfig().options().copyDefaults(true);
        this.cosmeticConfig.saveConfig();
        this.cosmeticConfig.reloadConfig();
        Bukkit.getLogger().info("[FateHub] Loading info.yml");
        this.infoConfig = new InfoConfig(Main.getPlugin(), "info.yml");
        this.infoConfig.saveConfig();
        this.infoConfig.getConfig().options().copyDefaults(true);
        this.infoConfig.saveConfig();
        this.infoConfig.reloadConfig();
    }

    public void saveConfgis() {
        playerData.saveConfig();
        registryData.saveConfig();
        scoreboardConfig.saveConfig();
        itemConfig.saveConfig();
        serverData.saveConfig();
    }

    public void reloadConfigs() {
        playerData.reloadConfig();
        registryData.reloadConfig();
        scoreboardConfig.reloadConfig();
        itemConfig.reloadConfig();
        serverData.reloadConfig();
    }

    public void registerManagers() {
        cc = new CC();
        manager = new ProfileManager();
        settingsManager = new SettingsManager();
        itemManager = new ItemManager();
        inventoryManager = new InventoryManager();
    }

}
