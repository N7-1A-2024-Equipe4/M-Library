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
        if (Session.getInstance().isSignedOut()) {
            MainController.getInstance().show(ViewEnum.LOGIN);
            return;
        }
        MainController.getInstance().show(ViewEnum.HOME);
    }


    public void listsAction() {
        if (Session.getInstance().isSignedOut()) {
            MainController.getInstance().show(ViewEnum.LOGIN);
            return;
        }
        MainController.getInstance().show(ViewEnum.LISTS);
    }

    public void profileAction() {
        if (Session.getInstance().isSignedOut()) {
            MainController.getInstance().show(ViewEnum.LOGIN);
            return;
        }
        MainController.getInstance().show(ViewEnum.PROFILE);
    }

    public void logoutAction() {
        Session.getInstance().logout();

        view.update();
        MainController.getInstance().show(ViewEnum.LOGIN);
    }

    public String getUsername() {
        if (Session.getInstance().isSignedOut()) {
            return "Not logged in";
        }
        return Session.getInstance().getUser().getUsername();
    }
}
