package exercise1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.sql.*;

public class PlayerGameApp extends Application {

    private static final String URL = "jdbc:oracle:thin:@199.212.26.208:1521:SQLD";
    private static final String USER = "COMP228_F24_SOH_59";
    private static final String PASSWORD = "password";

    @Override
    public void start(Stage primaryStage) {
    	// Main layout and Hbox
    	HBox mainLayout = new HBox(20);
        mainLayout.setPadding(new Insets(10));

        // Player Information Section
        TextField playerIdField = new TextField();
        TextField firstNameField = new TextField();
        TextField lastNameField = new TextField();
        TextField addressField = new TextField();
        TextField postalCodeField = new TextField();
        TextField provinceField = new TextField();
        TextField phoneNumberField = new TextField();

        GridPane playerForm = new GridPane();
        playerForm.setHgap(10);
        playerForm.setVgap(10);
        playerForm.add(new Label("Player ID:"), 0, 0);
        playerForm.add(playerIdField, 1, 0);
        playerForm.add(new Label("First Name:"), 0, 1);
        playerForm.add(firstNameField, 1, 1);
        playerForm.add(new Label("Last Name:"), 0, 2);
        playerForm.add(lastNameField, 1, 2);
        playerForm.add(new Label("Address:"), 0, 3);
        playerForm.add(addressField, 1, 3);
        playerForm.add(new Label("Postal Code:"), 0, 4);
        playerForm.add(postalCodeField, 1, 4);
        playerForm.add(new Label("Province:"), 0, 5);
        playerForm.add(provinceField, 1, 5);
        playerForm.add(new Label("Phone Number:"), 0, 6);
        playerForm.add(phoneNumberField, 1, 6);

        Button insertPlayerButton = new Button("Insert Player");
        Button updatePlayerButton = new Button("Update Player");

        HBox playerActions = new HBox(10, insertPlayerButton, updatePlayerButton);

        VBox playerSection = new VBox(10, new Label("Player Information"), playerForm, playerActions);

        // Game part
        TextField gameIdField = new TextField();
        TextField gameTitleField = new TextField();

        GridPane gameForm = new GridPane();
        gameForm.setHgap(10);
        gameForm.setVgap(10);
        gameForm.add(new Label("Game ID:"), 0, 0);
        gameForm.add(gameIdField, 1, 0);
        gameForm.add(new Label("Game Title:"), 0, 1);
        gameForm.add(gameTitleField, 1, 1);

        Button insertGameButton = new Button("Insert Game");

        VBox gameSection = new VBox(10, new Label("Game Information"), gameForm, insertGameButton);

        // Player-Game part
        TextField relationPlayerIdField = new TextField();
        TextField relationGameIdField = new TextField();
        DatePicker playingDatePicker = new DatePicker();
        TextField scoreField = new TextField();

        GridPane relationForm = new GridPane();
        relationForm.setHgap(10);
        relationForm.setVgap(10);
        relationForm.add(new Label("Player ID:"), 0, 0);
        relationForm.add(relationPlayerIdField, 1, 0);
        relationForm.add(new Label("Game ID:"), 0, 1);
        relationForm.add(relationGameIdField, 1, 1);
        relationForm.add(new Label("Playing Date:"), 0, 2);
        relationForm.add(playingDatePicker, 1, 2);
        relationForm.add(new Label("Score:"), 0, 3);
        relationForm.add(scoreField, 1, 3);

        Button insertRelationButton = new Button("Insert Player-Game Relation");
        Button displayReportButton = new Button("Display Player-Game Report");

        VBox relationSection = new VBox(10, new Label("Player-Game Relation"), relationForm, insertRelationButton, displayReportButton);

        VBox mainFormSection = new VBox(20, playerSection, gameSection, relationSection);
        mainFormSection.setPadding(new Insets(10));

        // report side
        TextArea reportArea = new TextArea();
        reportArea.setEditable(false);
        reportArea.setPrefSize(400, 600);

        mainLayout.getChildren().addAll(mainFormSection, reportArea);

        Scene scene = new Scene(mainLayout, 1000, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Player-Game Management");
        primaryStage.show();

        // Event Handlers
        insertPlayerButton.setOnAction(e -> {
            // database inserting
            try (Connection connection = DatabaseUtil.getConnection()) {
                String sql = "INSERT INTO Player (player_id, first_name, last_name, address, postal_code, province, phone_number) VALUES (?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setInt(1, Integer.parseInt(playerIdField.getText()));
                    preparedStatement.setString(2, firstNameField.getText());
                    preparedStatement.setString(3, lastNameField.getText());
                    preparedStatement.setString(4, addressField.getText());
                    preparedStatement.setString(5, postalCodeField.getText());
                    preparedStatement.setString(6, provinceField.getText());
                    preparedStatement.setString(7, phoneNumberField.getText());
                    preparedStatement.executeUpdate();
                    reportArea.setText("Player inserted!");
                }
            } catch (SQLException ex) {
                reportArea.setText("Error inserting player: " + ex.getMessage());
            }
        });

        updatePlayerButton.setOnAction(e -> {
            // updating the player info
            try (Connection connection = DatabaseUtil.getConnection()) {
                String sql = "UPDATE Player SET first_name = ?, last_name = ?, address = ?, postal_code = ?, province = ?, phone_number = ? WHERE player_id = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, firstNameField.getText());
                    preparedStatement.setString(2, lastNameField.getText());
                    preparedStatement.setString(3, addressField.getText());
                    preparedStatement.setString(4, postalCodeField.getText());
                    preparedStatement.setString(5, provinceField.getText());
                    preparedStatement.setString(6, phoneNumberField.getText());
                    preparedStatement.setInt(7, Integer.parseInt(playerIdField.getText()));
                    preparedStatement.executeUpdate();
                    reportArea.setText("Player updated!");
                }
            } catch (SQLException ex) {
                reportArea.setText("Error updating player: " + ex.getMessage());
            }
        });

        insertGameButton.setOnAction(e -> {
            // database game insterting
            try (Connection connection = DatabaseUtil.getConnection()) {
                String sql = "INSERT INTO Game (game_id, game_title) VALUES (?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setInt(1, Integer.parseInt(gameIdField.getText()));
                    preparedStatement.setString(2, gameTitleField.getText());
                    preparedStatement.executeUpdate();
                    reportArea.setText("Game inserted!");
                }
            } catch (SQLException ex) {
                reportArea.setText("Error inserting game: " + ex.getMessage());
            }
        });

        insertRelationButton.setOnAction(e -> {
            // p-g database insterting
            try (Connection connection = DatabaseUtil.getConnection()) {
                if (playingDatePicker.getValue() == null) {
                    reportArea.setText("Select a valid playing date!");
                    return;
                }
                String sql = "INSERT INTO PlayerAndGame (game_id, player_id, playing_date, score) VALUES (?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setInt(1, Integer.parseInt(relationGameIdField.getText()));
                    preparedStatement.setInt(2, Integer.parseInt(relationPlayerIdField.getText()));
                    preparedStatement.setDate(3, Date.valueOf(playingDatePicker.getValue()));
                    preparedStatement.setInt(4, Integer.parseInt(scoreField.getText()));
                    preparedStatement.executeUpdate();
                    reportArea.setText("Player-Game relation inserted!");
                }
            } catch (SQLException ex) {
                reportArea.setText("Error inserting relation: " + ex.getMessage());
            }
        });

        displayReportButton.setOnAction(e -> {
            // Display
            try (Connection connection = DatabaseUtil.getConnection()) {
                String sql = """
                        SELECT p.player_id, p.first_name, p.last_name, g.game_title, pg.playing_date, pg.score
                        FROM Player p
                        JOIN PlayerAndGame pg ON p.player_id = pg.player_id
                        JOIN Game g ON g.game_id = pg.game_id
                        """;
                try (Statement statement = connection.createStatement();
                     ResultSet resultSet = statement.executeQuery(sql)) {
                    StringBuilder report = new StringBuilder("Player-Game Report:\n");
                    while (resultSet.next()) {
                        report.append("Player ID: ").append(resultSet.getInt("player_id")).append(", ")
                              .append("Name: ").append(resultSet.getString("first_name")).append(" ")
                              .append(resultSet.getString("last_name")).append(", ")
                              .append("Game: ").append(resultSet.getString("game_title")).append(", ")
                              .append("Date: ").append(resultSet.getDate("playing_date")).append(", ")
                              .append("Score: ").append(resultSet.getInt("score")).append("\n");
                    }
                    reportArea.setText(report.toString());
                }
            } catch (SQLException ex) {
                reportArea.setText("Error displaying report: " + ex.getMessage());
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
