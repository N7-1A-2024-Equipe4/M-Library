package controller;

import model.User;
import service.UserService;
import session.Session;
import view.ProfileView;

public class ProfileController {
    private final ProfileView view;

    private final UserService userService;

    public ProfileController(ProfileView view) {
        this.view = view;
        this.userService = new UserService();
    }

    public void firstNameChangeAction(String firstName) {
        User newUser = new User(Session.getUser());
        newUser.setFirstName(firstName);
        if (!userService.updateUser(newUser.getId(), newUser)) {
            view.firstNameChangeFailed();
            return;
        }
        Session.getUser().setFirstName(firstName);
        view.refresh(null);
    }

    public void lastNameChangeAction(String lastName) {
        User newUser = new User(Session.getUser());
        newUser.setLastName(lastName);
        if (!userService.updateUser(newUser.getId(), newUser)) {
            view.lastNameChangeFailed();
            return;
        }
        Session.getUser().setLastName(lastName);
        view.refresh(null);
    }

    public void usernameChangeAction(String username) {
        // copy session user
        User newUser = new User(Session.getUser());
        // set new username
        newUser.setUsername(username);
        // update in database
        if (!userService.updateUser(newUser.getId(), newUser)) {
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
        if (!userService.updateUser(newUser.getId(), newUser)) {
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
