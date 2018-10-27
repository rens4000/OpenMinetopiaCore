package nl.rens4000.minetopiacore.utils;

import net.md_5.bungee.api.ChatColor;
import nl.rens4000.minetopiacore.manager.SettingsManager;

public class ChatUtils {
	
	private static ChatUtils chatutils;
	
	private static String prefix;
	
	private ChatUtils() {
		prefix = colorcode(SettingsManager.getConfig().getString("chat.prefix") + "&f");
	}
	
	public static ChatUtils getChatUtils() {
		if(chatutils == null) {
			chatutils = new ChatUtils();
		}
		return chatutils;
	}
	
	public String getPrefix() {
		return prefix;
	}
	
	public String colorcode(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}

}
