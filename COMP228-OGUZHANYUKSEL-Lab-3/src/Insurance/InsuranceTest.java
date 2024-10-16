package Insurance;

public class InsuranceTest {
    public static void main(String[] args) {
        Insurance[] insurances = new Insurance[2];
        insurances[0] = new Health();
        insurances[1] = new Life();

        insurances[0].setInsuranceCost(300.00);
        insurances[1].setInsuranceCost(500.00);

        for (Insurance insurance : insurances) {
            insurance.displayInfo();
        }
    }
}

abstract class Insurance {
    protected String insuranceType;
    protected double monthlyCost;

    public String getInsuranceType() {
        return insuranceType;
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }

    public abstract void setInsuranceCost(double cost);
    public abstract void displayInfo();
}

class Health extends Insurance {
    public Health() {
        insuranceType = "Health Insurance";
    }

    @Override
    public void setInsuranceCost(double cost) {
        monthlyCost = cost;
    }

    @Override
    public void displayInfo() {
        System.out.println("Insurance Type: " + insuranceType);
        System.out.println("Monthly Cost: $" + monthlyCost);
    }
}

class Life extends Insurance {
    public Life() {
        insuranceType = "Life Insurance";
    }

    @Override
    public void setInsuranceCost(double cost) {
        monthlyCost = cost;
    }

    @Override
    public void displayInfo() {
        System.out.println("Insurance Type: " + insuranceType);
        System.out.println("Monthly Cost: $" + monthlyCost);
    }
}
