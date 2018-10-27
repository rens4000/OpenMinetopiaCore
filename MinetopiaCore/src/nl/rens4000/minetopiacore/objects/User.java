package nl.rens4000.minetopiacore.objects;

import java.util.UUID;

public class User {
	
	private UUID uuid;
	private String job;
	private String rank;
	private int fatigue;
	private int thirst;
	
	public User(UUID uuid, String job, String rank, int fatigue, int thirst) {
		this.uuid = uuid;
		this.job = job;
		this.rank = rank;
		this.fatigue = fatigue;
		this.thirst = thirst;
	}
	
	/* 
	 * TODO: Make users file and make sure that the setters also 
	 * change the values in the configfile.
	 */

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public int getFatigue() {
		return fatigue;
	}

	public void setFatigue(int fatigue) {
		this.fatigue = fatigue;
	}

	public int getThirst() {
		return thirst;
	}

	public void setThirst(int thirst) {
		this.thirst = thirst;
	}

	public UUID getUuid() {
		return uuid;
	}
	
	

}
