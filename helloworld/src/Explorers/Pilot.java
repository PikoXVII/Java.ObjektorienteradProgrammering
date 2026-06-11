package Explorers;

import missions.Mission;

public class Pilot extends SpaceExplorer {
	public Pilot(String name) {
		super(name, "Pilot");
	}
	public Pilot(String name, Mission mission) {
		super(name, "Pilot", mission);
	}
	@Override
    public void reportStatus() {
        if (getMission() != null) {
            System.out.println("Pilot " + getName() + " is flying the spaceship for mission '" + getMission().getName() + "' to " + getMission().getDestination() + ".");
        } else {
            System.out.println("Pilot " + getName() + " has no mission right now.");
        }
    }
	

}
