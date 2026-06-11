package Lab0;
import java.util.Random;

public class Scenario5 {
	public static int[] reverse(int[] orginal) {
		int length = orginal.length;
		int[] reversed = new int[length];
		for(int i = 0; i < length;i++) {
			reversed[i] = orginal[length - 1 -i];
			
		}
		return reversed;
	}
	
	
	
	public static void main(String[] args) {
		int size = 5;
		int[] arr = new int[size];
		
		Random rand = new Random();
		for(int i =0; i < size; i++) {
			arr[i] = rand.nextInt(100);
		}
		
		System.out.println("Orginal: ");
		for(int n : arr) {
			System.out.println(n + " ");
		}
		
		int[] reversedArray = reverse(arr);
		System.out.println("Reversed: ");
		for(int n : reversedArray) {
			System.out.println(n + " ");
		}
	}

}
