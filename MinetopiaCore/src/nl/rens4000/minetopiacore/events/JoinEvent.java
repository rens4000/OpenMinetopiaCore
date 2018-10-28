package nl.rens4000.minetopiacore.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import nl.rens4000.minetopiacore.Core;
import nl.rens4000.minetopiacore.manager.SettingsManager;
import nl.rens4000.minetopiacore.manager.UsersManager;
import nl.rens4000.minetopiacore.objects.User;
import nl.rens4000.minetopiacore.utils.ChatUtils;

public class JoinEvent implements Listener {
	
	// Declares the chatutils class.
	ChatUtils chatUtils = ChatUtils.getChatUtils();
	
	@EventHandler
	public void onJoinEvent(PlayerJoinEvent event) {
		
		// Declares the player object.
		Player player = event.getPlayer();
		
		// Check if the player hasn't played before.
		if(!player.hasPlayedBefore()) {
			// If so. Give him/her their starters money.
			Core.getEconomy().depositPlayer(player, SettingsManager.getConfig().getInt("economy.starters-money"));
			
			// Create the user object for him so we can store variables :3
			createFirstUserObject(player);
			
			// Send nice message to welcome them and to say that they have recieved their starters money.
			player.sendMessage(chatUtils.getPrefix() + chatUtils.colorcode("&fWelcome to the server &3" + player.getName() + "&f!"));
			player.sendMessage(chatUtils.getPrefix() + "&6You have recieved &3" + SettingsManager.getConfig().getInt("economy.starters-money") + " &6dollar starters "
					+ "money from the bank.");
		
		} else { 
			// If the player has played before. Send them a nice message ;).
			player.sendMessage(chatUtils.getPrefix() + chatUtils.colorcode("&fWelcome back &3" + player.getName() + "&f!"));
			
			createUserObject(player);
		
		}
		
		// User object declaration
		User user = UsersManager.getUser(player.getUniqueId());
		
		// Create scoreboard for player.
		
		
	}
	
	
	
	private void createUserObject(Player player) {
		UsersManager.addUser(player.getUniqueId(),
				SettingsManager.getPlayers().getString("players." + player.getUniqueId() + ".job"),
				SettingsManager.getPlayers().getString("players." + player.getUniqueId() + ".rank"),
				SettingsManager.getPlayers().getInt("players." + player.getUniqueId() + ".fatigue"),
				SettingsManager.getPlayers().getInt("players." + player.getUniqueId() + ".thirst"));
	}

	private void createFirstUserObject(Player player) {
		UsersManager.addUser(player.getUniqueId(),
				SettingsManager.getConfig().getString("default.job"), SettingsManager.getConfig().getString("default.rank"), SettingsManager.getConfig().getInt("default.fatigue"), 0);
		
		// Add player to configfile
		SettingsManager.getPlayers().set("players." + player.getUniqueId() + ".job", SettingsManager.getConfig().getString("default.job"));
		SettingsManager.getPlayers().set("players." + player.getUniqueId() + ".rank", SettingsManager.getConfig().getString("default.rank"));
		SettingsManager.getPlayers().set("players." + player.getUniqueId() + ".fatigue", SettingsManager.getConfig().getString("default.fatigue"));
		SettingsManager.getPlayers().set("players." + player.getUniqueId() + ".thirst", 0);
		SettingsManager.saveConfig();
	}

}
