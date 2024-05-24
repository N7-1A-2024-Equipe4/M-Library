package controller;

import view.MainView;

public class NavbarController {

    public NavbarController() {
    }

    public void homeAction() {
        MainView.getInstance().showHome();
    }

    public void listsAction() {
        MainView.getInstance().showLists();
    }

    public void profileAction() {
        MainView.getInstance().showProfile();
    }
}
