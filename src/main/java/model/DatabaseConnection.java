package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://roundhouse.proxy.rlwy.net:15970/movie_database";
    private static final String USER = "root";
    private static final String PASSWORD = "ZgVBNQcDVBedxSknPJLpBjfmpfdgSCoq";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public void close() throws SQLException {
        this.getConnection().close();
    }

}