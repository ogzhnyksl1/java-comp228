package exercise1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AccountManagerApp extends Application {
    private Account account;
    private TextField amountField;
    private Label balanceLabel;
    private Label accountNumberLabel;

    @Override
    public void start(Stage primaryStage) {
        account = new Account("ACC12345", 1000.00);

        accountNumberLabel = new Label("Account Number: " + account.getAccountNumber());
        balanceLabel = new Label("Balance: $" + account.getBalance());
        amountField = new TextField();
        amountField.setEditable(false);
        amountField.setPromptText("Enter Amount");

        Button depositButton = new Button("Deposit");
        Button withdrawButton = new Button("Withdraw");

        depositButton.setOnAction(e -> {
            double amount = Double.parseDouble(amountField.getText());
            account.deposit(amount);
            updateBalance();
            amountField.clear();
        });

        withdrawButton.setOnAction(e -> {
            double amount = Double.parseDouble(amountField.getText());
            account.withdraw(amount);
            updateBalance();
            amountField.clear();
        });

        GridPane numpad = new GridPane();
        numpad.setHgap(5);
        numpad.setVgap(5);
        numpad.setAlignment(Pos.CENTER);

        for (int i = 1; i <= 9; i++) {
            int number = i;
            Button numberButton = new Button(String.valueOf(number));
            numberButton.setOnAction(e -> amountField.appendText(String.valueOf(number)));
            numpad.add(numberButton, (i - 1) % 3, (i - 1) / 3);
        }

        Button zeroButton = new Button("0");
        zeroButton.setOnAction(e -> amountField.appendText("0"));
        numpad.add(zeroButton, 1, 3);

        Button clearButton = new Button("Clear");
        clearButton.setOnAction(e -> amountField.clear());
        numpad.add(clearButton, 2, 3);

        VBox mainLayout = new VBox(10);
        mainLayout.setPadding(new Insets(10));
        mainLayout.getChildren().addAll(accountNumberLabel, balanceLabel, amountField, depositButton, withdrawButton, numpad);

        Scene scene = new Scene(mainLayout, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Account Manager");
        primaryStage.show();
    }

    private void updateBalance() {
        balanceLabel.setText("Balance: $" + account.getBalance());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
