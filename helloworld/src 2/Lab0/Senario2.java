package Lab0;
import java.util.Scanner;



public class Senario2{
	public static long factorial(int n) {
		if( n < 0) {
			System.out.println("Error, avoid negativ numbers!");
			return 1;
		}

		long resultat = 1;
		for(int i = 1; i <= n; i++) {
			resultat *= i; 
		}
		return resultat; 

	}



	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a value:");
		int number = sc.nextInt();
		long calculate = factorial(number);
		System.out.println("Results: " + calculate);
		sc.close();
	}

}