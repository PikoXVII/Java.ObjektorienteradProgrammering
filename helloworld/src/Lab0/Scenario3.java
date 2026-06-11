package Lab0;
import java.util.Scanner;

public class Scenario3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter two numbers: ");
		int first = sc.nextInt() % 5;
		System.out.println("And?: ");
		int second = sc.nextInt() % 5;
			if(first == 0 && second == 0) {
				System.out.println("1");
				
			} else {
				System.out.println("0");
			}
		}

	}

