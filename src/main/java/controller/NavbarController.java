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
        MainController.getInstance().show(ViewEnum.HOME);
    }


    public void listsAction() {
        MainController.getInstance().show(ViewEnum.LISTS);
    }

    public void profileAction() {
        MainController.getInstance().show(ViewEnum.PROFILE);
    }

    public void logoutAction() {
        Session.logout();

        view.refresh();
        MainController.getInstance().show(ViewEnum.LOGIN);
    }
}
