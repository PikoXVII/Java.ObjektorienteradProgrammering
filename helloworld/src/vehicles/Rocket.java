package vehicles;

public class Rocket implements SpaceVehicle {
	@Override
	public void launch() {
		System.out.println("Rocket launching: Igniting engines!");
		System.out.println();
	}
	@Override
	public void land() {
		System.out.println("Rocket landing.");
	}
	@Override
	public void transportCrew() {
		System.out.println("Rocket transporting crew.");
	
	}
	
	

}
