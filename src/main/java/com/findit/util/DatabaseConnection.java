package com.findit.util;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class DatabaseConnection {
 
    private static final String URL      = "jdbc:postgresql://localhost:5432/findit_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "your_password_here";
 
    private static Connection connection = null;
 
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (ClassNotFoundException e) {
                throw new SQLException("Driver not found.");
            }
        }
        return connection;
    }
 
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }
}
 
