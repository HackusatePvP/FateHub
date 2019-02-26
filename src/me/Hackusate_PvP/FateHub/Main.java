package me.Hackusate_PvP.FateHub;

import com.bizarrealex.azazel.Azazel;
import io.github.thatkawaiisam.assemble.Assemble;
import io.github.thatkawaiisam.assemble.AssembleStyle;
import lombok.Getter;
import me.Hackusate_PvP.FateHub.Commands.player.*;
import me.Hackusate_PvP.FateHub.Commands.staff.InfoCommand;
import me.Hackusate_PvP.FateHub.Commands.staff.StatusCommand;
import me.Hackusate_PvP.FateHub.Listeners.Inventories.*;
import me.Hackusate_PvP.FateHub.Listeners.Player.*;
import me.Hackusate_PvP.FateHub.Profiles.ProfileManager;
import me.Hackusate_PvP.FateHub.Scoreboard.BoardLink;
import me.Hackusate_PvP.FateHub.Tab.TabLink;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Logger;

public class Main extends JavaPlugin {
    public static Main plugin;
    public FileConfiguration config;
    @Getter public API API;
    private final Logger log = Bukkit.getLogger();
    private static Permission perms = null;

    public void onEnable() {
        plugin = this;
        log.info("[FateHub] Initiating...");
        log.info("[FateHub] Loading API...");
        API = new API();
        Main.getPlugin().getAPI().registerManagers();
        log.info("[FateHub] Loading Configs...");
        this.reloadConfig();
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
        this.saveDefaultConfig();
        config = this.getConfig();
        Main.getPlugin().getAPI().registerConfigs();
        log.info("[FateHub] Loading managers...");
        this.registerCommands();
        this.registerManagers();
        log.info("[FateHub] Checking dependencies...");
        if (!setupPermissions()) {
            log.severe("[FateHub] ERROR Permission plugin not found. Disabling...");
            getServer().getPluginManager().disablePlugin(this);
        }
        log.info("[FateHub] Loading scoreboard...");
        //Start Instance
        Assemble assemble = new Assemble(this,new BoardLink());
        //Set Interval (Tip: 20 ticks = 1 second)
        assemble.setTicks(2);
        //Set Style (Tip: Viper Style starts at -1 and goes down)
        assemble.setAssembleStyle(AssembleStyle.KOHI);
        log.info("[FateHub] Loading tablist...");
        new Azazel(this, new TabLink());
        log.info("[FateHub] Done.");

    }

    public void onDisable() {
        log.info("[FateHub] Disabling...");
        log.info("[FateHub] Saving...");
        this.saveData();
        plugin = null;
    }

    private void registerCommands() {
        getCommand("fatehub").setExecutor(new FateHubCommand());
        getCommand("register").setExecutor(new RegisterCommand());
        getCommand("login").setExecutor(new LoginCommand());
        getCommand("settings").setExecutor(new SettingsCommand());
        getCommand("info").setExecutor(new InfoCommand());
        getCommand("status").setExecutor(new StatusCommand());
        getCommand("resetinventory").setExecutor(new ResetInventory());
        getCommand("toggleplayers").setExecutor(new TogglePlayers());
        getCommand("togglescoreboard").setExecutor(new ToggleScoreboard());
    }

    private void registerManagers() {
        PluginManager manager = this.getServer().getPluginManager();
        manager.registerEvents(new JoinEvent(), this);
        manager.registerEvents(new ProfileManager(), this);
        manager.registerEvents(new DoubleJumpEvent(), this);
        manager.registerEvents(new EnderButtListener(), this);
        manager.registerEvents(new ServerSelectorManager(), this);
        manager.registerEvents(new DamageEvnt(), this);
        manager.registerEvents(new FoodEvnt(), this);
        manager.registerEvents(new DeathEvnt(), this);
        manager.registerEvents(new SettingsHandler(), this);
        manager.registerEvents(new StatusHandler(), this);
        manager.registerEvents(new CosmeticsHandler(), this);
        manager.registerEvents(new InteractEvnt(), this);
        manager.registerEvents(new BuildEvnt(), this);
    }

    private void saveData() {
        getAPI().reloadConfigs();
        this.reloadConfig();
        getAPI().saveConfgis();
        this.saveConfig();
    }

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }

    public static Permission getPermissions() {
        return perms;
    }

    public static Main getPlugin() {
        return plugin;
    }
}
