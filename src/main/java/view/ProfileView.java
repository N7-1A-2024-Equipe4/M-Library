package view;

import controller.ProfileController;
import model.User;

import javax.swing.*;

public class ProfileView extends View {
    private final ProfileController controller;
    private JPanel panel;
    private JLabel usernameLabel;
    private JButton usernameButton;
    private JLabel passwordLabel;
    private JButton passwordButton;

    public ProfileView() {
        controller = new ProfileController(this);
        usernameButton.addActionListener(actionEvent -> controller.usernameAction());
        passwordButton.addActionListener(actionEvent -> controller.passwordAction());
    }

    @Override
    public JPanel getPanel() {
        return this.panel;
    }

    @Override
    public void update() {
        User user = controller.getUser();
        usernameLabel.setText(user.getUsername());
        passwordLabel.setText(user.getPassword());
    }
}
