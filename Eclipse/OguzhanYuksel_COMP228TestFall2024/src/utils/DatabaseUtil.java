package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

    public static Connection getConnection() {
    Connection connection = null;
    try {
        Class.forName("oracle.jdbc.OracleDriver");
        String url = "jdbc:oracle:thin:@oracle1.centennialcollege.ca:1521:SQLD";
        String username = "COMP228_F24_soh_59";
        String password = "password";
        connection = DriverManager.getConnection(url, username, password);
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
        System.out.println("Oracle JDBC Driver not found.");
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Failed to establish a database connection.");
    }
    return connection;
}

}
