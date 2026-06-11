package Lab0;
import java.util.Scanner;
public class Scenerio1A{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = Integer.MIN_VALUE;
		System.out.println("Skriv ut tre olika tal!");
		for(int i = 0; i <3; i++) {
			int input  = sc.nextInt();
			if ( num < input) {
				num = input;
			}
		}
		System.out.println("Det största tal är " + num +  "!" );
		
		
		
		
		
	}
}