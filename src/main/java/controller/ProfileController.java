package controller;

import model.User;
import session.Session;
import view.ProfileView;

public class ProfileController {
    private User user;
    private final ProfileView view;

    public ProfileController(ProfileView view) {
        this.view = view;
        this.user = Session.getInstance().getUser();
    }

    public void usernameAction() {
        user.setUsername("newUsername");
        // TODO should update the navbar if changed user is the current session user
        MainController.getInstance().updateNavbar();
        view.update();
    }

    public void passwordAction() {
        user.setPassword("newPassword");
        view.update();
    }

    public User getUser() {
        user = Session.getInstance().getUser();
        return user;
    }
}
