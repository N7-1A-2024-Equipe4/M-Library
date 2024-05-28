package controller;

import session.Session;
import view.LoginView;
import view.ViewEnum;

public class LoginController {
    private final LoginView view;

    public LoginController(LoginView view) {
        this.view = view;
    }

    public void loginAction(String username) {
        if (!Session.login(username)) {
            view.loginFailed();
            return;
        }
        MainController mainController = MainController.getInstance();
        mainController.updateNavbar();
        mainController.show(ViewEnum.PROFILE);
    }
}
