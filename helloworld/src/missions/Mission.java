package missions;
import vehicles.SpaceVehicle;

public abstract class Mission {
	private String destination;
	private int durationDays;
	private String name;
	private SpaceVehicle rocket;
	
	public Mission(String name, String destination, int durationDays, SpaceVehicle rocket) {
		this.name = name;
		this.destination = destination;
		this.durationDays = durationDays;
		this.rocket = rocket;
	}
	
	// getters
	public String getDestination() {
		return destination;
	}
	public int getDurationDays() {
		return durationDays;
	}
	public String getName() {
		return name;
	}
	public SpaceVehicle getRocket() {
		return rocket;
	}
	//setters
	public void setName(String name) {
		this.name = name;
	}
	public abstract void performMission();


}


