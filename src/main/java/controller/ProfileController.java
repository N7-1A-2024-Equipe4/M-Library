package controller;

import model.User;
import service.SessionService;
import service.UserService;
import view.ProfileView;
import view.ViewEnum;

public class ProfileController {
    private final ProfileView view;

    private final UserService userService;

    public ProfileController(ProfileView view) {
        this.view = view;
        this.userService = new UserService();
    }

    public void saveChangesAction(String firstName, String lastName, String username, String password) {
        // copy session user
        User updatedUser = new User(SessionService.getUser());
        // update fields if not blank
        if (!firstName.isBlank()) {
            updatedUser.setFirstName(firstName);
        }
        if (!lastName.isBlank()) {
            updatedUser.setLastName(lastName);
        }
        if (!username.isBlank()) {
            updatedUser.setUsername(username);
        }
        if (!password.isBlank()) {
            updatedUser.setPassword(password);
        }
        // update user
        if (!userService.updateUser(updatedUser.getId(), updatedUser)) {
            view.userChangeFail();
            return;
        }
        // logout and login to refresh the user in the session
        SessionService.logout();
        if (SessionService.login(updatedUser.getUsername(), updatedUser.getPassword())) {
            view.refresh(null);
            view.userChangeSuccess();
        } else {
            view.userChangeFail();
        }
    }

    public void showLibrariesAction(int userId) {
        MainController.getInstance().show(ViewEnum.LIBRARIES, userId);
    }
}
