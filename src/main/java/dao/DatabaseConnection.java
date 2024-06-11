package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://alcoolis.me:3306/mlibrary";
    private static final String USER = "mlibrary";
    private static final String PASSWORD = "0}S2jB,-WG(?4K727>2@";

    private static DatabaseConnection instance;

    private static Connection connection;

    private DatabaseConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public PreparedStatement prepareStatement(String query) throws SQLException {
        return connection.prepareStatement(query);
    }

    public void close() throws SQLException {
        connection.close();
    }
}
