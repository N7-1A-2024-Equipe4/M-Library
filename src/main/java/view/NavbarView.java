package view;

import controller.NavbarController;
import service.SessionService;

import javax.swing.*;

public class NavbarView implements View {
    private final NavbarController controller;
    private JPanel panel;
    private JButton homeButton;
    private JButton profileButton;
    private JButton librariesButton;
    private JLabel usernameLabel;
    private JButton logoutButton;
    private JButton searchButton;

    public NavbarView() {
        controller = new NavbarController(this);
        homeButton.addActionListener(actionEvent -> controller.homeAction());
        profileButton.addActionListener(actionEvent -> controller.profileAction());
        librariesButton.addActionListener(actionEvent -> controller.librariesAction());
        searchButton.addActionListener(actionEvent -> controller.searchAction());
        logoutButton.addActionListener(actionEvent -> controller.logoutAction());
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public void refresh(Integer movieId) {
        if (SessionService.isLoggedIn()) {
            logoutButton.setText("Logout");
            usernameLabel.setText(SessionService.getUser().getUsername());
        } else {
            logoutButton.setText("Login");
            usernameLabel.setText("Not logged in");
        }
    }

}
