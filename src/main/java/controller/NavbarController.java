package controller;

import service.SessionService;
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

    public void profileAction() {
        MainController.getInstance().show(ViewEnum.PROFILE, null);
    }

    public void librariesAction() {
        MainController.getInstance().show(ViewEnum.LIBRARIES, null);
    }

    public void searchAction() {
        MainController.getInstance().show(ViewEnum.SEARCH, null);
    }

    public void logoutAction() {
        SessionService.logout();

        view.refresh(null);
        MainController.getInstance().show(ViewEnum.LOGIN, null);
    }
}
