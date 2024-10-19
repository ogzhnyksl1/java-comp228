package Exercise3;

public class PersonalMortgage extends Mortgage {

    public PersonalMortgage(String customerName, double amount, double rate, int term) {
        super(customerName, amount, rate + 0.02, term);  // Add 2% interest rate
    }

    @Override
    public void getMortgageInfo() {
        System.out.println("Personal Mortgage - " + customerName);
        System.out.println("Amount: $" + amount + ", Interest Rate: " + (interestRate * 100) + "%");
        System.out.println("Term: " + term + " years, Bank: " + BANK_NAME);
    }
}
