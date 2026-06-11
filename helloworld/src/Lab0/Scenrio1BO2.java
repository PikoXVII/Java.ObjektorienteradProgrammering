package Lab0;
import java.util.Scanner;

/*public class Scenrio1BO2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter, the amount of number you wish!:");
		int value = sc.nextInt();
		System.out.println("Thanks for your responds");
		System.out.println("The sekvens of (" + value + ") would be:");
		for(int i = 0; i < value; i++) {
			int num = sc.nextInt();
			System.out.println("Sekvens: " + num);
			 
			
		}
		System.out.println("Thank you for your cooperation!");
		sc.close();
		
		
	}
}
	*/

public class Scenrio1BO2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter, the amount of number u wish!:");
		int value = sc.nextInt();
		System.out.println("Thanks for submitting! ");
		int[] num = new int[value];
		for(int i = 0; i < value; i++) {
			num[i] = sc.nextInt();
			System.out.println("Nums gave: " + (i+1) + ":" + num[i]);
		}
		System.out.println("Thanks for your cooperation!");
		sc.close();
	}
}

