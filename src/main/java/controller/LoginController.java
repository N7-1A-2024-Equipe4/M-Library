package controller;

import session.Session;
import view.LoginView;
import view.ViewEnum;

public class LoginController {
    private final LoginView view;

    public LoginController(LoginView view) {
        this.view = view;
    }

    public void loginAction(String username, String password) {
        if (!Session.login(username, password)) {
            view.loginFailed();
            return;
        }
        MainController mainController = MainController.getInstance();
        mainController.updateNavbar();
        mainController.show(ViewEnum.PROFILE);
    }
}
