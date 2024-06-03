package view;

import controller.ProfileController;
import model.User;
import session.Session;

import javax.swing.*;
import java.awt.*;

public class ProfileView implements View {
    private final ProfileController controller;
    private JPanel panel;
    private JLabel usernameLabel;
    private JButton changeUsernameButton;
    private JLabel passwordLabel;
    private JButton changePasswordButton;

    public ProfileView() {
        controller = new ProfileController(this);
        changeUsernameButton.addActionListener(actionEvent -> controller.usernameChangeAction("newUsername"));
        changePasswordButton.addActionListener(actionEvent -> controller.passwordChangeAction("newPassword"));
    }

    @Override
    public JPanel getPanel() {
        return this.panel;
    }

    @Override
    public void refresh() {
        User user = Session.getUser();
        usernameLabel.setText(user.getUsername());
        passwordLabel.setText(user.getPassword());
    }

    // TODO refactor?: add success and error methods in View interface with default implementation
    public void usernameChangeSuccess(String username) {
        JOptionPane.showMessageDialog(panel, "Username changed successfully to " + username, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public void usernameChangeFailed() {
        JOptionPane.showMessageDialog(panel, "Username change failed", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void passwordChangeSuccess() {
        JOptionPane.showMessageDialog(panel, "Password changed successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public void passwordChangeFailed() {
        JOptionPane.showMessageDialog(panel, "Password change failed", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void weirdFail() {
        JOptionPane.showMessageDialog(panel, "Weird fail", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
