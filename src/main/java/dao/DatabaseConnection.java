package dao;

import java.sql.*;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://roundhouse.proxy.rlwy.net:15970/mlibrary";
    private static final String USER = "root";
    private static final String PASSWORD = "ZgVBNQcDVBedxSknPJLpBjfmpfdgSCoq";

    private static DatabaseConnection instance;

    private DatabaseConnection() {
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Connection connection = this.getConnection();
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public void close() throws SQLException {
        this.getConnection().close();
    }
}