package view;

import controller.NavbarController;
import session.Session;

import javax.swing.*;

public class NavbarView implements View {
    private final NavbarController controller;
    private JPanel panel;
    private JButton homeButton;
    private JButton profileButton;
    private JButton librariesButton;
    private JLabel usernameLabel;
    private JButton logoutButton;

    public NavbarView() {
        controller = new NavbarController(this);
        homeButton.addActionListener(actionEvent -> controller.homeAction());
        profileButton.addActionListener(actionEvent -> controller.profileAction());
        librariesButton.addActionListener(actionEvent -> controller.librariesAction());
        logoutButton.addActionListener(actionEvent -> controller.logoutAction());
    }

    @Override
    public JPanel getPanel() {
        return null;
    }

    @Override
    public void refresh(Integer movieID) {
        usernameLabel.setText(Session.getUsername());
        logoutButton.setText(Session.isLoggedIn() ? "Logout" : "Login");
    }

}
