package view;

import controller.NavbarController;

import javax.swing.*;

public class NavbarView extends View {
    private final NavbarController controller;
    private JPanel panel;
    private JButton homeButton;
    private JButton listsButton;
    private JButton profileButton;
    private JLabel usernameLabel;
    private JButton logoutButton;

    public NavbarView() {
        controller = new NavbarController(this);
        homeButton.addActionListener(actionEvent -> controller.homeAction());
        listsButton.addActionListener(actionEvent -> controller.listsAction());
        profileButton.addActionListener(actionEvent -> controller.profileAction());
        logoutButton.addActionListener(actionEvent -> controller.logoutAction());
    }

    @Override
    public JPanel getPanel() {
        return null;
    }

    @Override
    public void update() {
        // FIXME should a view update fetch from model directly? or should it be passed the data? or should it fetch from controller?
        usernameLabel.setText(controller.getUsername());
    }
}
