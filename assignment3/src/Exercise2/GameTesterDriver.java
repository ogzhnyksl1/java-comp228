package Exercise2;

import java.util.Scanner;

public class GameTesterDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter tester name: ");
        String name = scanner.nextLine();

        System.out.print("Is the tester full-time? (yes/no): ");
        boolean isFullTime = scanner.nextLine().equalsIgnoreCase("yes");

        GameTester tester;
        if (isFullTime) {
            tester = new FullTimeGameTester(name);
        } else {
            System.out.print("Enter hours worked: ");
            int hours = scanner.nextInt();
            tester = new PartTimeGameTester(name, hours);
        }

        System.out.println("Tester Salary: $" + tester.determineSalary());
    }
}
