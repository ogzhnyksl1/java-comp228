package Exercise3;

public abstract class Mortgage implements MortgageConstants {
    protected String customerName;
    protected double amount;
    protected double interestRate;
    protected int term;

    public Mortgage(String customerName, double amount, double rate, int term) {
        this.customerName = customerName;
        if (amount > MAX_AMOUNT) {
            System.out.println("Amount exceeds maximum limit! Setting to $300,000.");
            this.amount = MAX_AMOUNT;
        } else {
            this.amount = amount;
        }
        this.interestRate = rate;
        this.term = (term == SHORT_TERM || term == MEDIUM_TERM || term == LONG_TERM)
                ? term : SHORT_TERM;  // Default to SHORT_TERM if invalid
    }

    public abstract void getMortgageInfo();
}
