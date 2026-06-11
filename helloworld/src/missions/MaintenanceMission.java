package missions;

import vehicles.SpaceVehicle;


public class MaintenanceMission extends Mission{
	public MaintenanceMission(String name, String destination, int durationDays, SpaceVehicle rocket){
		super(name, destination, durationDays , rocket);
		
	}
	
	@Override
	public void performMission() {
		System.out.println("Performing maintenance at " + getDestination() + " for " + getDurationDays() + " days...");
	}
	
	

}
