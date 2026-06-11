package Explorers;
import missions.Mission;
import vehicles.SpaceVehicle;

public class Commander extends SpaceExplorer {
	
	private SpaceExplorer[] team;

	public Commander(String name) {
		super(name, "Commander");
	}
	public Commander(String name, Mission mission) {
		super(name, "Commander", mission);
	}
	
	public Commander(String name, Mission mission, SpaceExplorer[] team) {
		super(name, "Commander", mission);
		this.team = team;
	}
	public SpaceExplorer[] getTeam() {
		return team;
	}
	@Override
    public void reportStatus() {
        if (getMission() != null) {
            System.out.println("Commander " + getName() + " is leading mission '" + getMission().getName() + "'.");
        } else {
            System.out.println("Commander " + getName() + " has no mission assigned.");
        }
        
    }
	
	public void performDuty() {
		if (getMission() == null || getMission().getRocket() == null) {
			System.out.println("Commander " + getName() + " cannot start because mission or rocket is missing.");
			return;
		}
		getMission().getRocket().transportCrew(); // transportera besättning
		getMission().getRocket().launch(); // starta raketen
		getMission().performMission(); // utför själva missionen
		
		if (team != null) {
			for(int i = 0; i < team.length; i++) {
				team[i].startMission();
			}
			System.out.println();
			for (int i = 0; i < team.length; i++) {
				team[i].reportStatus();
			}
			System.out.println();
			for(int i = 0; i < team.length; i++) {
				team[i].completeMission();
			}
			System.out.println();
		} else {
			System.out.println("Commander " + getName() + " has no team assigned.");
		}
		System.out.println();
		getMission().getRocket().land();
		System.out.println("Commander " + getName() + " finalized mission: " + getMission().getName());
	}

	
}
