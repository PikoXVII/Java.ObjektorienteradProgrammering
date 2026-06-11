package Explorers;
import missions.Mission;

public class Engineer extends SpaceExplorer {
	public Engineer(String name) {
		super(name, "Engineer");
	}
	public Engineer(String name, Mission mission) {
		super(name, "Engineer", mission);
	}
	@Override
    public void reportStatus() {
        if (getMission() != null) {
            System.out.println("Engineer " + getName() + " is working on mission " + getMission().getName() + "' at " + getMission().getDestination() + ".");    
        } else {
            System.out.println("Engineer " + getName() + " has no mission right now.");
        }
    }

}
