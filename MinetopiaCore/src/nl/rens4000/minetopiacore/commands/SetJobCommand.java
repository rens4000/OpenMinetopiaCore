package nl.rens4000.minetopiacore.commands;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import nl.rens4000.minetopiacore.utils.ChatUtils;
import nl.rens4000.minetopiacore.utils.Messages;

public class SetJobCommand implements CommandExecutor, TabExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		// Checks if the sender is not a player.
		if(!(sender instanceof Player)) {
			// if so, send him/her a message that he/she has to be a player to perform the command.
			sender.sendMessage(ChatUtils.getChatUtils().getPrefix() + Messages.NOT_A_PLAYER.getMessage());
			// Don't execute the rest of the code. Because he/she isn't a player.
			return true;
		}
		
		//Declares the player object.
		Player player = (Player) sender;
		
		if(!player.hasPermission("minetopiacore.setjob")) {
			sender.sendMessage(ChatUtils.getChatUtils().getPrefix() + Messages.NO_PERMISSION.getMessage());
			return true;
		}
		
		if(args.length != 1) {
			sender.sendMessage(ChatUtils.getChatUtils().getPrefix() + Messages.WRONG_USAGE.getMessage().replaceAll("<usage>", "/setjob <job>"));
			return true;
		}
		
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		return null;
	}
	
	

}
