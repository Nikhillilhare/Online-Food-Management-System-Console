package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL =
            "jdbc:mysql://localhost:3306/food_ordering_system";

    private static final String USERNAME = "W1_92793_Nikhil";

    private static final String PASSWORD = "manager";

    public static Connection getConnection() {

        try {

            return DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (SQLException e) {

            System.out.println("Database Connection Failed.");
            e.printStackTrace();

        }

        return null;

    }
}
