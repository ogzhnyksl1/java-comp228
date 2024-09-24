package exercise1;
import javax.swing.*;
import java.util.Random;

public class Test {

    //array for q's
    String[] questions = {
            "What is Java?",
            "Who created Java?",
            "What does JVM stand for?",
            "What is the extension of Java files?",
            "Which method is the entry point of any Java program?"
    };

    //second array for a's
    String[][] options = {
            {"A programming language", "A coffee", "A car brand", "A fruit"},
            {"James Gosling", "Bill Gates", "Elon Musk", "Steve Jobs"},
            {"Java Virtual Machine", "Java Very Much", "Java View Manager", "Java Visible Memory"},
            {".java", ".jav", ".jv", ".j"},
            {"main()", "start()", "run()", "execute()"}
    };

    //correct answers array
    int[] correctAnswers = {0, 0, 0, 0, 0};

    public void simulateQuestion(int index) {
        String question = questions[index];
        String message = question + "\n";
        for (int i = 0; i < options[index].length; i++) {
            message += (i + 1) + ". " + options[index][i] + "\n";
        }
        JOptionPane.showMessageDialog(null, message);
    }

    public int inputAnswer() {
        String answer = JOptionPane.showInputDialog("Enter the number of your answer (1-4): ");
        return Integer.parseInt(answer) - 1;
    }

    public boolean checkAnswer(int questionIndex, int userAnswer) {
        return userAnswer == correctAnswers[questionIndex];
    }

    public String generateMessage(boolean isCorrect) {
        Random random = new Random();
        int response = random.nextInt(4);
        if (isCorrect) {
            switch (response) {
                case 0: return "Excellent!";
                case 1: return "Good!";
                case 2: return "Keep up the good work!";
                case 3: return "Nice work!";
            }
        } else {
            switch (response) {
                case 0: return "No. Please try again.";
                case 1: return "Wrong. Try once more.";
                case 2: return "Don't give up!";
                case 3: return "No. Keep trying...";
            }
        }
        return "";
    }

    //main method
    public void startTest() {
        int correctCount = 0;

        for (int i = 0; i < questions.length; i++) {
            simulateQuestion(i);
            int userAnswer = inputAnswer();
            boolean isCorrect = checkAnswer(i, userAnswer);

            JOptionPane.showMessageDialog(null, generateMessage(isCorrect));

            if (isCorrect) {
                correctCount++;
            }
        }

        int percentage = (correctCount * 100) / questions.length;
        JOptionPane.showMessageDialog(null, "Test finished!\nCorrect answers: " + correctCount + "\nPercentage: " + percentage + "%");
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.startTest();
    }
}
