package controller;

import view.MainView;

public class NavbarController {

    public NavbarController() {
    }

    public void homeAction() {
        MainView.getInstance().setCurrentView(MainView.View.HOME);
    }

    public void listsAction() {
        MainView.getInstance().setCurrentView(MainView.View.LISTS);
    }

    public void profileAction() {
        MainView.getInstance().setCurrentView(MainView.View.PROFILE);
    }
}
