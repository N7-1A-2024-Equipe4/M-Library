package dao;

import model.User;

public class UserDAO {
    public static User getUser(String username) {
        // TODO: Implement this method
        return new User(username, "password");
    }
}
