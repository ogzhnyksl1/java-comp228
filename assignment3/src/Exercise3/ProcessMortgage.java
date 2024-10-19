package Exercise3;

import java.util.Scanner;

public class ProcessMortgage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Mortgage[] mortgages = new Mortgage[3];

        for (int i = 0; i < mortgages.length; i++) {
            System.out.print("Enter customer name: ");
            String name = scanner.nextLine();

            System.out.print("Enter mortgage amount (max $300,000): ");
            double amount = scanner.nextDouble();

            System.out.print("Enter interest rate: ");
            double rate = scanner.nextDouble();

            System.out.print("Enter term (1, 3, or 5 years): ");
            int term = scanner.nextInt();
            scanner.nextLine();  // Clear the buffer

            System.out.print("Enter mortgage type (Business/Personal): ");
            String type = scanner.nextLine();

            if (type.equalsIgnoreCase("Business")) {
                mortgages[i] = new BusinessMortgage(name, amount, rate, term);
            } else {
                mortgages[i] = new PersonalMortgage(name, amount, rate, term);
            }
        }

        System.out.println("\nMortgage Details:");
        for (Mortgage mortgage : mortgages) {
            mortgage.getMortgageInfo();
            System.out.println();
        }
    }
}
