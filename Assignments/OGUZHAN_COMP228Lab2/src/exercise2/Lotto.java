package exercise2;
import javax.swing.*;
import java.util.Random;

// Lotto class to generate random numbers and simulate a lotto game
// where the user tries to match the sum of three numbers within five attempts.

public class Lotto {
    private int[] lottoNumbers = new int[3];

    public Lotto() {
        Random random = new Random();
        for (int i = 0; i < lottoNumbers.length; i++) {
            lottoNumbers[i] = random.nextInt(9) + 1;
        }
    }

    public int[] getLottoNumbers() {
        return lottoNumbers;
    }

    public static void main(String[] args) {
        int chosenNumber = Integer.parseInt(JOptionPane.showInputDialog("Choose a number between 3 and 27: "));

        for (int i = 0; i < 5; i++) {
            Lotto lotto = new Lotto();
            int sum = 0;
            for (int num : lotto.getLottoNumbers()) {
                sum += num;
            }
            JOptionPane.showMessageDialog(null, "Lotto numbers: " + lotto.getLottoNumbers()[0] + ", " + lotto.getLottoNumbers()[1] + ", " + lotto.getLottoNumbers()[2] + "\nSum: " + sum);

            if (sum == chosenNumber) {
                JOptionPane.showMessageDialog(null, "Congratulations! You win!");
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Sorry, the computer wins.");
    }
}
