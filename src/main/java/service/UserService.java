package service;

import dao.UserDAO;
import model.User;
import session.Session;

import java.sql.SQLException;

public class UserService {

    private final UserDAO userDao;

    public UserService() {
        this.userDao = new UserDAO();
    }

    public boolean updateUser(int id, User user) {
        if (user.getUsername().isBlank()) {
            return false;
        }
        if (!isUserAuthorized(id)) {
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

    private static boolean isUserAuthorized(int id) {
        return Session.getUser().getId() == id;
    }

}
