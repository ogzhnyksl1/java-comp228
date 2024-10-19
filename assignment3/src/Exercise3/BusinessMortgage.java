package Exercise3;

public class BusinessMortgage extends Mortgage {

    public BusinessMortgage(String customerName, double amount, double rate, int term) {
        super(customerName, amount, rate + 0.01, term);  // Add 1% interest rate
    }

    @Override
    public void getMortgageInfo() {
        System.out.println("Business Mortgage - " + customerName);
        System.out.println("Amount: $" + amount + ", Interest Rate: " + (interestRate * 100) + "%");
        System.out.println("Term: " + term + " years, Bank: " + BANK_NAME);
    }
}
