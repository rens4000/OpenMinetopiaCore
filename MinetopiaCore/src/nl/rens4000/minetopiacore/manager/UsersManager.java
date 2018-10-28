package nl.rens4000.minetopiacore.manager;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import nl.rens4000.minetopiacore.objects.User;
import nl.rens4000.minetopiacore.utils.ChatUtils;

public class UsersManager {
	
	static private Set<User> users = new HashSet<User>();
	
	public static Set<User> getUsers() {
		return users;
	}
	
	public static User getUser(UUID uuid) {
		for(User u : users) {
			if(u.getUuid().equals(uuid)) return u;
		}
		return null;
	}
	
	public static void addUser(UUID uuid, String job, String rank, int fatigue, int thirst) {
		User u = new User(uuid, job, rank, fatigue, thirst);
		users.add(u);
	}
	
	public void setScoreBoard(Player player) {
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective servername = board.registerNewObjective("ServerName", "dummy");
        servername.setDisplaySlot(DisplaySlot.SIDEBAR);
        servername.setDisplayName(ChatUtils.getChatUtils().colorcode(SettingsManager.getConfig().getString("scoreboard.servername")));
        // Work further
  }
	
}
