package dao;

import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAO extends DAO<User> {

    public User getUserByUsername(String username) throws SQLException {
        User user = null;
        String query = "SELECT * FROM user WHERE username = ? LIMIT 1";
        try (PreparedStatement preparedStatement = databaseConnection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                var id = resultSet.getInt("user_id");
                var fetchedUsername = resultSet.getString("username");
                var password = resultSet.getString("password");
                var firstName = resultSet.getString("first_name");
                var lastName = resultSet.getString("last_name");
                var createdAt = resultSet.getDate("created_at");
                user = new User(id, fetchedUsername, password, firstName, lastName, createdAt);
            }
        }
        return user;
    }

    @Override
    public void add(User entity) throws SQLException {
        ;
    }

    @Override
    public List<User> getAll() throws SQLException {
        return List.of();
    }

    @Override
    public User getById(int id) throws SQLException {
        User user = null;
        String query = "SELECT * FROM user WHERE user_id = ? LIMIT 1";
        try (PreparedStatement preparedStatement = databaseConnection.prepareStatement(query)) {
            preparedStatement.setString(1, Integer.toString(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                var fetchedUsername = resultSet.getString("username");
                var password = resultSet.getString("password");
                var firstName = resultSet.getString("first_name");
                var lastName = resultSet.getString("last_name");
                var createdAt = resultSet.getDate("created_at");
                user = new User(id, fetchedUsername, password, firstName, lastName, createdAt);
            }
        }
        return user;
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
}
