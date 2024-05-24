package controller;

import view.MainView;

public class NavbarController {

    public NavbarController() {
    }

    public void homeAction() {
        MainView.getInstance().setCurrentView(MainView.Views.HOME);
    }

    public void listsAction() {
        MainView.getInstance().setCurrentView(MainView.Views.LISTS);
    }

    public void profileAction() {
        MainView.getInstance().setCurrentView(MainView.Views.PROFILE);
    }
}
