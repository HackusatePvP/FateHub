package me.Hackusate_PvP.FateHub.Files;

import me.Hackusate_PvP.FateHub.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;

public class ScoreboardConfig {
        private final String fileName;
        private final JavaPlugin plugin;
        private File configFile;
        private FileConfiguration fileConfiguration;

        public ScoreboardConfig(Main plugin, String fileName) {
            if (plugin == null)
                throw new IllegalArgumentException("plugin cannot be null");
            if (!plugin.isInitialized())
                throw new IllegalArgumentException("plugin must be initialized");
            this.plugin = plugin;
            this.fileName = fileName;
            File dataFolder = plugin.getDataFolder();
            if (dataFolder == null)
                throw new IllegalStateException();
            this.configFile = new File(plugin.getDataFolder(), fileName);
        }

        public void reloadConfig() {
            fileConfiguration = YamlConfiguration.loadConfiguration(configFile);

            // Look for defaults in the jar
            InputStream defConfigStream = plugin.getResource(fileName);
            if (defConfigStream != null) {
                YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
                fileConfiguration.setDefaults(defConfig);
            }
        }

        public FileConfiguration getConfig() {
            if (fileConfiguration == null) {
                this.reloadConfig();
            }
            return fileConfiguration;
        }

        public void saveConfig() {
            if (fileConfiguration == null || configFile == null) {
                return;
            } else {
                try {
                    getConfig().save(configFile);
                } catch (IOException ex) {
                    plugin.getLogger().log(Level.SEVERE, "Could not save resources to " + configFile, ex);
                }
            }
        }

        public void saveDefaultConfig() {
            if (!configFile.exists()) {
                this.plugin.saveResource(fileName, false);
            }
        }
}
