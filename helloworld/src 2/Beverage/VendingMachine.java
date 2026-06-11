package Beverage;
import java.util.Scanner;

public class VendingMachine {
    private Beverage[] beverage;
    private int BeverageCount;
    private int totalPurchases = 0;
    private double totalCost = 0;

    public void setBev(Beverage[] beverage) {
        this.beverage = beverage;
        this.BeverageCount = beverage.length;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        boolean keepGoing = true;

        while (keepGoing) {
            printMenu();

            System.out.print("Välj en dryck (nummer): ");
            int val = sc.nextInt();

            if (val == beverage.length + 1) {
                keepGoing = false;
            } else if (val >= 1 && val <= beverage.length) {
                serve(val);
            } else {
                System.out.println("Ogiltigt val. Försök igen.");
            }
        }

        printSummary();
    }

    
    private void printMenu() {
        System.out.println("\nMENY:");
        for (int i = 0; i < beverage.length; i++) {
            System.out.println((i + 1) + ". " + beverage[i].getName());
        }
        System.out.println((beverage.length + 1) + ". Avsluta och visa summering");
    }

    
    private void serve(int val) {
        Beverage valde = beverage[val - 1];

        if (valde.getStock() > 0) {
            valde.setStock(valde.getStock() - 1);
            valde.setTimesSelected(valde.getTimesSelected() + 1);
            totalPurchases++;
            totalCost += valde.getPrice();
            System.out.println("Du fick: " + valde.getName());
        } else {
            System.out.println("Tyvärr! " + valde.getName() + " är slut.");
        }
    }

    // 3. Visa summering
    private void printSummary() {
    	System.out.println("PURCHASE SUMMARY");
        System.out.println("Totalt antal köpt: " + totalPurchases);
        System.out.printf("Total Pris: %.2f $.\n", totalCost);
        for (int i = 0; i < beverage.length; i++) {
            Beverage b = beverage[i];
            System.out.println("- " + b.getName() + ": " + b.getTimesSelected() + " gånger");
        }
    }
}
 