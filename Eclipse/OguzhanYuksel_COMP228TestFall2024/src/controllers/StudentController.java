package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import models.Students;
import utils.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentController {
    public static ObservableList<Students> getStudentsByCity(String city) {
        ObservableList<Students> studentList = FXCollections.observableArrayList();

        String query = "SELECT studentID, firstName, lastName, address, city, province, postalCode FROM Students WHERE city = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, city);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Students student = new Students(
                        resultSet.getString("studentID"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("address"),
                        resultSet.getString("city"),
                        resultSet.getString("province"),
                        resultSet.getString("postalCode")
                );
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentList;
    }
}
