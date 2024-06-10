package dao;

import java.sql.*;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://alcoolis.me:3306/mlibrary";
    private static final String USER = "mlibrary";
    private static final String PASSWORD = "0}S2jB,-WG(?4K727>2@";

    private static DatabaseConnection instance;

    private DatabaseConnection() {
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public PreparedStatement prepareStatement(String query) throws SQLException {
        return this.getConnection().prepareStatement(query);
    }

    public void close() throws SQLException {
        this.getConnection().close();
    }
}