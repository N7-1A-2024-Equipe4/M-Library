package controller;

import dao.UserDAO;
import session.Session;
import view.LoginView;
import view.ViewEnum;

public class LoginController {
    private final LoginView view;

    public LoginController(LoginView view) {
        this.view = view;
    }

    public void loginAction(String username) {
        Session.getInstance().login(UserDAO.getUser(username));
        MainController mainController = MainController.getInstance();
        mainController.updateNavbar();
        mainController.show(ViewEnum.PROFILE);
    }
}
