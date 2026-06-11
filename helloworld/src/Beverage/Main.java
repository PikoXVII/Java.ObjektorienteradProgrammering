package Beverage;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random rand = new Random();
		Beverage[] drinks = {
				new Beverage("Coffee", 2.0, rand.nextInt(20) + 1),
				new Beverage("Fanta", 1.5, rand.nextInt(20) + 1),
				new Beverage("Cola", 1.5, rand.nextInt(20) + 1),
				new Beverage("Water", 1.0, rand.nextInt(20) + 1)
		};
		VendingMachine vm = new VendingMachine();
		vm.setBev(drinks);
		vm.run();
		
	}
}
