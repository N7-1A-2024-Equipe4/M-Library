package dao;

import model.Library;
import model.User;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DAO<User> {

    public User findUserByUsername(String username) throws SQLException {
        String query = "SELECT * FROM user WHERE username = ? LIMIT 1";
        try (PreparedStatement preparedStatement = databaseConnection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return getUserFromResultSet(resultSet);
            }
        }
        return null;
    }

    @Override
    public User add(User entity) throws SQLException {

        return null;
    }

    @Override
    public List<User> getAll() throws SQLException {
        return List.of();
    }

    @Override
    public User getById(int id) throws SQLException {
        String query = "SELECT * FROM user WHERE user_id = ? LIMIT 1";
        try (PreparedStatement preparedStatement = databaseConnection.prepareStatement(query)) {
            preparedStatement.setString(1, Integer.toString(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return getUserFromResultSet(resultSet);
            }
        }
        return null;
    }

    private static User getUserFromResultSet(ResultSet resultSet) throws SQLException {
        var id = resultSet.getInt("user_id");
        var fetchedUsername = resultSet.getString("username");
        var password = resultSet.getString("password");
        var firstName = resultSet.getString("first_name");
        var lastName = resultSet.getString("last_name");
        var createdAt = resultSet.getDate("created_at");
//        var picture = resultSet.getBlob("picture"); TODO: Implement picture
        var picture = new ImageIcon("src/main/resources/profile.png"); // TODO: Remove this line and uncomment the line above when picture is implemented

        return new User(id, fetchedUsername, password, firstName, lastName, createdAt, picture);
    }

    @Override
    public void update(int id, User entity) throws SQLException {
        String query = "UPDATE user SET username = ?, password = ?, first_name = ?, last_name = ? WHERE user_id = ?";
        try (PreparedStatement preparedStatement = databaseConnection.prepareStatement(query)) {
            preparedStatement.setString(1, entity.getUsername());
            preparedStatement.setString(2, entity.getPassword());
            preparedStatement.setString(3, entity.getFirstName());
            preparedStatement.setString(4, entity.getLastName());
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {

    }

    public List<User> findByUsername(String username) throws SQLException {
        String query = "SELECT * FROM user WHERE username LIKE ?";
        var users = new ArrayList<User>();
        try (PreparedStatement preparedStatement = databaseConnection.prepareStatement(query)) {
            preparedStatement.setString(1, "%" + username + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                users.add(getUserFromResultSet(resultSet));
            }
        }
        return users;
    }
}
