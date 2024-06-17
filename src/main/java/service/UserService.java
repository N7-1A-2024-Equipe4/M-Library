package service;

import dao.UserDAO;
import model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {

    private final UserDAO userDao;

    public UserService() {
        this.userDao = new UserDAO();
    }

    public boolean updateUser(int id, User user) {
        if (user.getUsername().isBlank()) {
            return false;
        }
        if (!isAuthedUser(id)) {
            return false;
        }
        try {
            userDao.update(id, user);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public User getUser(Integer modelId) {
        try {
            return userDao.getById(modelId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isAuthedUser(int id) {
        return SessionService.getUser().getId() == id;
    }

    public List<User> searchUsers(String query) {
        try {
            return userDao.findByUsername(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
