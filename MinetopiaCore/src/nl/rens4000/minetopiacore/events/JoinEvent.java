package nl.rens4000.minetopiacore.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import nl.rens4000.minetopiacore.Core;
import nl.rens4000.minetopiacore.manager.SettingsManager;
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
			
			// Send nice message to welcome them and to say that they have recieved their starters money.
			player.sendMessage(chatUtils.getPrefix() + chatUtils.colorcode("&fWelcome to the server &3" + player.getName() + "&f!"));
			player.sendMessage(chatUtils.getPrefix() + "&6You have recieved &3" + SettingsManager.getConfig().getInt("economy.starters-money") + " &6dollar starters "
					+ "money from the bank.");
		
		} else { 
			// If the player has played before. Send them a nice message ;).
			player.sendMessage(chatUtils.getPrefix() + chatUtils.colorcode("&fWelcome back &3" + player.getName() + "&f!"));
		
		}
	}

}
