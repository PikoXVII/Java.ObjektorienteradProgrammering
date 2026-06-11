package missions;
import vehicles.SpaceVehicle;

public class ExplorationMission extends Mission{
	
	public ExplorationMission(String name, String destination, int durationDays, SpaceVehicle rocket) {
		super(name, destination, durationDays, rocket);
	}
	@Override
	public void performMission() {
		System.out.println("Exploring" + getDestination() + " for " + getDurationDays() + " days...");
	}
	
}
