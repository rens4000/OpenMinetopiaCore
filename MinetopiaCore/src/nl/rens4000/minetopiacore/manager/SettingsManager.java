package nl.rens4000.minetopiacore.manager;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import nl.rens4000.minetopiacore.utils.ChatUtils;

public class SettingsManager {
	
	static ChatUtils chatUtils = ChatUtils.getChatUtils();
	
    static FileConfiguration config, players;
    static File configfile, playersfile;

    public static void setup() {
    	configfile = new File("plugins/OpenMinetopiaCore/", "config.yml");
    	playersfile = new File("plugins/OpenMinetopiaCore/", "players.yml");

        if (!configfile.exists()) {
            try {
            	configfile.createNewFile();
            	playersfile.createNewFile();
            } catch (IOException e) {
            }
        }

        config = YamlConfiguration.loadConfiguration(configfile);
        players = YamlConfiguration.loadConfiguration(playersfile);
    }

    public static FileConfiguration getConfig() {
        return config;
    }
    
    public static FileConfiguration getPlayers() {
        return players;
    }

    public static void saveConfig() {
        try {
        	config.save(configfile);
        } catch (IOException e) {
            Bukkit.getServer().getLogger().severe(chatUtils.colorcode("&4Could not load config.yml"));
        }
    }
    
    public static void savePlayers() {
        try {
        	players.save(playersfile);
        } catch (IOException e) {
            Bukkit.getServer().getLogger().severe(chatUtils.colorcode("&4Could not load players.yml"));
        }
    }

    public static void reload() {
    	config = YamlConfiguration.loadConfiguration(configfile);
    	players = YamlConfiguration.loadConfiguration(playersfile);
    }

	
}
