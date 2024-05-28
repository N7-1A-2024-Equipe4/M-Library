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
        if (Session.isSignedOut()) {
            MainController.getInstance().show(ViewEnum.LOGIN);
            return;
        }
        MainController.getInstance().show(ViewEnum.HOME);
    }


    public void listsAction() {
        if (Session.isSignedOut()) {
            MainController.getInstance().show(ViewEnum.LOGIN);
            return;
        }
        MainController.getInstance().show(ViewEnum.LISTS);
    }

    public void profileAction() {
        if (Session.isSignedOut()) {
            MainController.getInstance().show(ViewEnum.LOGIN);
            return;
        }
        MainController.getInstance().show(ViewEnum.PROFILE);
    }

    public void logoutAction() {
        Session.logout();

        view.update();
        MainController.getInstance().show(ViewEnum.LOGIN);
    }
}
