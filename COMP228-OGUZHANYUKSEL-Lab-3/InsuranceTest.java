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