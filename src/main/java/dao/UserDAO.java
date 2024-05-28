package dao;

import model.User;

import java.util.HashMap;
import java.util.Map;

public class UserDAO {
    // FIXME temporary Database mock
    private static Map<String, String> users = new HashMap<>(
            Map.of("admin", "admin_pw")
    );

    public static User getUserByUsername(String username) {
        if (users.get(username) == null) {
            return null;
        }
        return new User(username, users.get(username));
    }

    public static void updateUserByUsername(String username, User user) {
        if (users.get(username) == null || user == null) {
            return;
        }
        if (user.getUsername() != null && users.get(user.getUsername()) == null) {
            users.put(user.getUsername(), users.get(username));
            users.remove(username);
        }
        if (user.getPassword() != null) {
            users.put(username, user.getPassword());
        }
    }
}
