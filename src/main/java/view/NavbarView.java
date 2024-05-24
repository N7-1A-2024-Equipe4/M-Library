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
        controller = new NavbarController();
        homeButton.addActionListener(actionEvent -> controller.homeAction());
        listsButton.addActionListener(actionEvent -> controller.listsAction());
        profileButton.addActionListener(actionEvent -> controller.profileAction());
    }
}
