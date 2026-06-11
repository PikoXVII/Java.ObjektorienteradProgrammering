package Explorers;
import missions.Mission;

public abstract class SpaceExplorer {
	private final int id;
	private String name;
	private Mission mission;
	protected String rank;
	private static int nextID = 1;
	
	SpaceExplorer(String name, String rank){
		this.id = nextID++;
		this.name = name;
		this.rank = rank;
	}
	
	SpaceExplorer(String name, String rank, Mission mission){
		this.id = nextID++;
		this.name = name;
		this.rank = rank;
		this.mission = mission;
	}
	public void startMission() {
		if (mission != null)
			System.out.println(rank + " " + name + " is starting mission: " + mission.getName());
		else
			System.out.println(rank + " " + name + " has no mission assigned.");
	}
	public void completeMission() {
		if (mission != null) {
			System.out.println(rank + " " + name + " has completed mission: " + mission.getName());
		} else {
			System.out.println(rank + " " + name + " has no mission assigned.");
		}
	}
	public abstract void reportStatus();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public String getRank() { return rank; }

	public void setRank(String rank) {
		this.rank = rank;
	}

	public int getId() {
		return id;
	}

}
