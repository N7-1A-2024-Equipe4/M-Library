package controller;

import dao.UserDAO;
import model.User;
import session.Session;
import view.ProfileView;

public class ProfileController {
    private final ProfileView view;

    public ProfileController(ProfileView view) {
        this.view = view;
    }

    public void usernameChangeAction(String username) {
        UserDAO.updateUserByUsername(Session.getUsername(), new User(username, null));
        if (Session.login(username)) {
            MainController.getInstance().updateNavbar();
            view.refresh();
            view.usernameChangeSuccess(username);
        }
    }

    public void passwordAction(String password) {
        UserDAO.updateUserByUsername(Session.getUsername(), new User(null, password));
        view.refresh();
    }
}
