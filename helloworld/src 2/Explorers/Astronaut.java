package Explorers;
import missions.Mission;

public class Astronaut extends SpaceExplorer{
	public Astronaut(String name) {
		super(name, "Astronaut");
	}
	public Astronaut(String name, Mission mission) {
		super(name, "Astronaut", mission);
	}
	@Override
	public void reportStatus() {
	    if (getMission() != null) {
	        System.out.println("Astronaut " + getName() + " is conducting scientific experiments for mission '" + getMission().getName() + "' at " + getMission().getDestination() + ".");
	    } else {
	        System.out.println("Astronaut " + getName() + " has no mission assigned.");
	    }
	}



}

