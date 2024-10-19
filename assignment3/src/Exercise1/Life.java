package Exercise1;

public class Life extends Insurance {
    public Life() {
        type = "Life Insurance";
    }

    @Override
    public void setInsuranceCost(double cost) {
        this.monthlyCost = cost;
    }

    @Override
    public void displayInfo() {
        System.out.println("Type: " + type + ", Monthly Cost: $" + monthlyCost);
    }
}
