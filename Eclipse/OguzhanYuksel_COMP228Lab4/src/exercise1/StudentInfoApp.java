package exercise1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class StudentInfoApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Main layout
        BorderPane mainLayout = new BorderPane();
        mainLayout.setPadding(new Insets(10));

        // Form fields for student details
        GridPane formGrid = new GridPane();
        formGrid.setVgap(10);
        formGrid.setHgap(10);
        formGrid.setPadding(new Insets(10));

        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        Label addressLabel = new Label("Address:");
        TextField addressField = new TextField();
        Label cityLabel = new Label("City:");
        TextField cityField = new TextField();
        Label provinceLabel = new Label("Province:");
        TextField provinceField = new TextField();
        Label postalCodeLabel = new Label("Postal Code:");
        TextField postalCodeField = new TextField();
        Label phoneLabel = new Label("Phone Number:");
        TextField phoneField = new TextField();
        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();

        formGrid.add(nameLabel, 0, 0);
        formGrid.add(nameField, 1, 0);
        formGrid.add(addressLabel, 0, 1);
        formGrid.add(addressField, 1, 1);
        formGrid.add(provinceLabel, 0, 2);
        formGrid.add(provinceField, 1, 2);
        formGrid.add(cityLabel, 0, 3);
        formGrid.add(cityField, 1, 3);
        formGrid.add(postalCodeLabel, 0, 4);
        formGrid.add(postalCodeField, 1, 4);
        formGrid.add(phoneLabel, 0, 5);
        formGrid.add(phoneField, 1, 5);
        formGrid.add(emailLabel, 0, 6);
        formGrid.add(emailField, 1, 6);

        // Checkboxes for additional activities
        CheckBox studentCouncilCheckBox = new CheckBox("Student Council");
        CheckBox volunteerWorkCheckBox = new CheckBox("Volunteer Work");
        formGrid.add(studentCouncilCheckBox, 1, 7);
        formGrid.add(volunteerWorkCheckBox, 1, 8);

        mainLayout.setLeft(formGrid);

        // Major selection with radio buttons
        RadioButton csRadio = new RadioButton("Computer Science");
        RadioButton businessRadio = new RadioButton("Business");
        ToggleGroup majorGroup = new ToggleGroup();
        csRadio.setToggleGroup(majorGroup);
        businessRadio.setToggleGroup(majorGroup);

        VBox majorBox = new VBox(10, new Label("Select Major:"), csRadio, businessRadio);
        majorBox.setPadding(new Insets(10));

        // Courses ComboBox and ListView
        ComboBox<String> courseComboBox = new ComboBox<>();
        ListView<String> courseListView = new ListView<>();

        csRadio.setOnAction(e -> courseComboBox.getItems().setAll("Java", "Python", "C#"));
        businessRadio.setOnAction(e -> courseComboBox.getItems().setAll("Accounting", "Marketing", "Economics"));

        courseComboBox.setOnAction(e -> {
            String selectedCourse = courseComboBox.getValue();
            if (selectedCourse != null && !courseListView.getItems().contains(selectedCourse)) {
                courseListView.getItems().add(selectedCourse);
            }
        });

        VBox courseBox = new VBox(10, new Label("Select Courses:"), courseComboBox, new Label("Courses Selected:"), courseListView);
        courseBox.setPadding(new Insets(10));

        VBox rightBox = new VBox(10, majorBox, courseBox);
        rightBox.setPadding(new Insets(10));
        mainLayout.setRight(rightBox);

        // Display area for student information
        TextArea displayArea = new TextArea();
        displayArea.setPrefHeight(100);
        displayArea.setEditable(false);

        Button displayButton = new Button("Display");
        displayButton.setOnAction(e -> {
            StringBuilder studentInfo = new StringBuilder();
            studentInfo.append(nameField.getText()).append(", ");
            studentInfo.append(addressField.getText()).append(", ");
            studentInfo.append(cityField.getText()).append(", ");
            studentInfo.append(provinceField.getText()).append(", ");
            studentInfo.append(postalCodeField.getText()).append(", ");
            studentInfo.append(phoneField.getText()).append(", ");
            studentInfo.append(emailField.getText()).append("\n");

            studentInfo.append("Courses: ");
            if (!courseListView.getItems().isEmpty()) {
                studentInfo.append(String.join(", ", courseListView.getItems()));
            } else {
                studentInfo.append("None");
            }
            displayArea.setText(studentInfo.toString());
        });

        VBox displayBox = new VBox(10, displayButton, displayArea);
        displayBox.setPadding(new Insets(10));
        mainLayout.setBottom(displayBox);

        // Set up and show the stage
        Scene scene = new Scene(mainLayout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Student Information Entry");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
