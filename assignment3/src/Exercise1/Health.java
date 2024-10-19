package Exercise1;

public class Health extends Insurance {
    public Health() {
        type = "Health Insurance";
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
