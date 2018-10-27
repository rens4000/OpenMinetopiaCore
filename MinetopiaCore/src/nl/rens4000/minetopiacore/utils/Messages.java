package nl.rens4000.minetopiacore.utils;

public enum Messages {

	NO_PERMISSION("&4You don't have permission to do that."), 
	PLAYER_DOESNT_EXIST("&4The given player does not exist or is not on the server right now."), 
	WRONG_USAGE("&4You used the command incorrectly. Usage: &f<usage>."),
	NOT_A_PLAYER("&4You can't perform that that command, because you appear to not be a player. ");
	
	String message;
	
	Messages(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return ChatUtils.getChatUtils().colorcode(message);
	}
	
}
