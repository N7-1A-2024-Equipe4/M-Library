package controller;

import session.Session;
import view.NavbarView;
import view.ViewEnum;

public class NavbarController {

    private final NavbarView view;

    public NavbarController(NavbarView view) {
        this.view = view;
    }

    public void homeAction() {
        MainController.getInstance().show(ViewEnum.HOME, null);
    }

    public void listsAction() {
        MainController.getInstance().show(ViewEnum.LISTS, null);
    }

    public void profileAction() {
        MainController.getInstance().show(ViewEnum.PROFILE, null);
    }

    public void logoutAction() {
        Session.logout();

        view.refresh(null);
        MainController.getInstance().show(ViewEnum.LOGIN, null);
    }
}
