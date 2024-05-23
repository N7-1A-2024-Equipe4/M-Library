package view;

import controller.NavbarController;

import javax.swing.*;

public class NavbarView {
    private final NavbarController controller;
    private JPanel panel;
    private JButton homeButton;
    private JButton listsButton;
    private JButton profileButton;

    public NavbarView() {
        controller = new NavbarController(this);
    }

    public JButton getHomeButton() {
        return homeButton;
    }

    public JButton getListsButton() {
        return listsButton;
    }

    public JButton getProfileButton() {
        return profileButton;
    }
}
