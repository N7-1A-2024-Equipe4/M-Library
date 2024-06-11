package controller;

import dao.UserDAO;
import model.User;
import session.Session;
import view.ProfileView;

import java.sql.SQLException;

public class ProfileController {
    private final ProfileView view;

    private final UserDAO userDao;

    public ProfileController(ProfileView view) {
        this.view = view;
        this.userDao = new UserDAO();
    }

    public void usernameChangeAction(String username) {
        // copy session user
        User newUser = new User(Session.getUser());
        // set new username
        newUser.setUsername(username);
        // update in database
        try {
            userDao.update(newUser.getId(), newUser);
        } catch (SQLException e) {
            e.printStackTrace();
            view.usernameChangeFailed();
            return;
        }
        // log back in
        Session.logout();
        if (Session.login(newUser.getUsername(), newUser.getPassword())) {
            MainController.getInstance().updateNavbar();
            view.refresh(null);
            view.usernameChangeSuccess(username);
        } else {
            view.weirdFail();
        }
    }

    public void passwordChangeAction(String password) {
        // copy session user
        User newUser = new User(Session.getUser());
        // set new password
        newUser.setPassword(password);
        // update in database
        try {
            userDao.update(newUser.getId(), newUser);
        } catch (SQLException e) {
            e.printStackTrace();
            view.passwordChangeFailed();
            return;
        }
        // log back in
        Session.logout();
        if (Session.login(newUser.getUsername(), newUser.getPassword())) {
            MainController.getInstance().updateNavbar();
            view.refresh(null);
            view.passwordChangeSuccess();
        } else {
            view.weirdFail();
        }
    }
}
