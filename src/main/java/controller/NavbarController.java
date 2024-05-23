package controller;

import view.MainView;
import view.NavbarView;

public class NavbarController {
    private final NavbarView view;

    public NavbarController(NavbarView navbarView) {
        this.view = navbarView;
        this.view.getHomeButton().addActionListener(e -> MainView.getInstance().showHome());
        this.view.getListsButton().addActionListener(e -> MainView.getInstance().showLists());
        this.view.getProfileButton().addActionListener(e -> MainView.getInstance().showProfile());
    }
}
