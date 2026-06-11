package Lab0;
import java.util.Scanner;

public class Scenrio1B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		System.out.println("Enter, many number as you wish!");
		for(int i = 0; ; i++) {
			int input  = sc.nextInt();
			if ( num < input) {
				num = input;
			}
			if(input == -1 || input < 0) {
				System.out.println("System Crashed");
				break;
			}


		}
		System.out.println("Highest number: " + num +  "!" );
		sc.close();
	}
}



