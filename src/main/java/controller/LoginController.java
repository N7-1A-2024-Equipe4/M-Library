package controller;

import service.SessionService;
import service.UserService;
import view.LoginView;
import view.LoginView.LoginError;
import view.ViewEnum;

import java.util.Set;


public class LoginController {
    private final LoginView view;
    private final UserService userService;

    public LoginController(LoginView view) {
        this.view = view;
        this.userService = new UserService();
    }

    public void loginAction(String username, String password) {
        Set<LoginError> errors = new java.util.HashSet<>();
        if (username.isBlank()) {
            errors.add(LoginError.EMPTY_USERNAME);
        }
        if (password.isBlank()) {
            errors.add(LoginError.EMPTY_PASSWORD);
        }
        if (!errors.isEmpty()) {
            view.loginFailed(errors);
            return;
        }
        if (SessionService.login(username, password)) {
            MainController mainController = MainController.getInstance();
            mainController.updateNavbar();
            mainController.show(ViewEnum.PROFILE, null);
        } else {
            view.loginFailed(Set.of(LoginError.WRONG_USERNAME_AND_PASSWORD));
        }
    }
}
