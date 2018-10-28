package nl.rens4000.minetopiacore;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import net.milkbowl.vault.economy.Economy;
import nl.rens4000.minetopiacore.events.JoinEvent;
import nl.rens4000.minetopiacore.manager.SettingsManager;

/*
 * 
 * Author: rens4000.
 * 
 * This project has been licensed with
 * a MIT license. Check license.txt.
 * 
 */

public class Core extends JavaPlugin {
	
	private static final Logger log = Logger.getLogger("Minecraft");
	private static Economy econ = null;
	
	private PluginManager pluginManager;
	
	/* When the plugin gets enabled. */
	@Override
	public void onEnable() {
		
		pluginManager = Bukkit.getPluginManager();
		
		if (!setupEconomy() ) {
            log.severe("Could not boot plugin. Reason: Vault could not be found.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
		
		/* Load/generates configfiles. */
		setupConfigFiles();
		
		/* Registers all events */
		registerEvents();
		
		Bukkit.getLogger().info(getDescription().getName() + " v" + getDescription().getVersion() + " has booted.");
	
	}
	
	private void registerEvents() {
		pluginManager.registerEvents(new JoinEvent(), this);
	}

	private void setupConfigFiles() {
		// Executes setup in the settingsmanager.
		SettingsManager.setup();
		
		// Adds config properties that will be added by default.
		SettingsManager.getConfig().addDefault("chat.prefix", "&7[&3Minetopia&cCore&7]");
		
		SettingsManager.getConfig().addDefault("standard.job", "&7Citizen");
		SettingsManager.getConfig().addDefault("standard.rank", "&7Player");
		SettingsManager.getConfig().addDefault("standard.fatigue", "100");
		
		SettingsManager.getConfig().addDefault("scoreboard.servername", "MyServer");
		
		// Says that the defaults need to be copied to the file.
		SettingsManager.getConfig().options().copyDefaults(true);
		
		// Saves the configfile
		SettingsManager.saveConfig();
	}
	
	private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }
	
	public static Economy getEconomy() {
		return econ;
	}

}
