package controllers;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import models.Students;
import utils.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MainApp extends Application {

    private TableView<Students> tableView = new TableView<>();
    private ObservableList<Students> studentList = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Student Info");

        //saerching city
        TextField cityInput = new TextField();
        cityInput.setPromptText("Please enter a city...");
        Button searchButton = new Button("Search");

        TableColumn<Students, String> idColumn = new TableColumn<>("Student ID");
        idColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getStudentID()));

        TableColumn<Students, String> firstNameColumn = new TableColumn<>("First Name");
        firstNameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getFirstName()));

        TableColumn<Students, String> lastNameColumn = new TableColumn<>("Last Name");
        lastNameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getLastName()));

        TableColumn<Students, String> addressColumn = new TableColumn<>("Address");
        addressColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getAddress()));

        TableColumn<Students, String> cityColumn = new TableColumn<>("City");
        cityColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCity()));

        TableColumn<Students, String> provinceColumn = new TableColumn<>("Province");
        provinceColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getProvince()));

        TableColumn<Students, String> postalCodeColumn = new TableColumn<>("Postal Code");
        postalCodeColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPostalCode()));

        tableView.getColumns().addAll(idColumn, firstNameColumn, lastNameColumn, addressColumn, cityColumn, provinceColumn, postalCodeColumn);

        //search button
        searchButton.setOnAction(e -> fetchStudents(cityInput.getText()));

        //design layot
        HBox searchBox = new HBox(10, cityInput, searchButton);
        BorderPane layout = new BorderPane();
        layout.setTop(searchBox);
        layout.setCenter(tableView);

        //scene
        Scene scene = new Scene(layout, 800, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void fetchStudents(String city) {
        studentList.clear();
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Students WHERE city = ?")) {
            stmt.setString(1, city);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                studentList.add(new Students(
                        rs.getString("student_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("address"),
                        rs.getString("city"),
                        rs.getString("province"),
                        rs.getString("postal_code")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        tableView.setItems(studentList);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
