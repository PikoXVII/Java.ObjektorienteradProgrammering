package Lab0;

public class Scenario4 {



	public static String fractionAdd(int n1, int d1, int n2, int d2) {


		int commonDenominator = d1 * d2;
		int nomi = d1 * n2;
		int nomi2 = d2 * n1;
		int addition = nomi + nomi2;
		double result = addition / (double) commonDenominator;
		return addition + "/" + commonDenominator + "=" + result; 
	}



	public static void main(String[] args) {
		String add = fractionAdd(2,3,5,6);
		System.out.println(add);

	}

}
