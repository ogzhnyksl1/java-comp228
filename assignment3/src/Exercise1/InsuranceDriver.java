package Exercise1;

import java.util.Scanner;

public class InsuranceDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Insurance[] insurances = new Insurance[2];

        for (int i = 0; i < 2; i++) {
            System.out.print("Enter insurance type (Health/Life): ");
            String type = scanner.nextLine();

            System.out.print("Enter the monthly cost: ");
            double cost = scanner.nextDouble();
            scanner.nextLine();  // Clear the buffer

            if (type.equalsIgnoreCase("Health")) {
                insurances[i] = new Health();
            } else {
                insurances[i] = new Life();
            }
            insurances[i].setInsuranceCost(cost);
        }

        System.out.println("\nInsurance Information:");
        for (Insurance insurance : insurances) {
            insurance.displayInfo();
        }
    }
}
