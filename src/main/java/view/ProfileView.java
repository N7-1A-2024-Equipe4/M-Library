package view;

import controller.ProfileController;
import model.User;
import service.UserService;
import session.Session;

import javax.swing.*;

public class ProfileView implements View {
    private final ProfileController controller;
    private final UserService userService;
    private JPanel panel;
    private JLabel profilePictureLabel;
    private JLabel usernameLabel;
    private JButton changeUsernameButton;
    private JLabel passwordLabel;
    private JButton changePasswordButton;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel firstNameLabel;
    private JTextField firstNameField;
    private JButton changeFirstNameButton;
    private JLabel lastNameLabel;
    private JTextField lastNameField;
    private JButton changeLastNameButton;

    public ProfileView() {
        this.controller = new ProfileController(this);
        this.userService = new UserService();
//        changeFirstNameButton.addActionListener(actionEvent -> controller.firstNameChangeAction(firstNameField.getText()));
//        changeLastNameButton.addActionListener(actionEvent -> controller.lastNameChangeAction(lastNameField.getText()));
//        changeUsernameButton.addActionListener(actionEvent -> controller.usernameChangeAction(usernameField.getText()));
//        changePasswordButton.addActionListener(actionEvent -> controller.passwordChangeAction(Arrays.toString(passwordField.getPassword())));
    }

    @Override
    public JPanel getPanel() {
        return this.panel;
    }

    @Override
    public void refresh(Integer modelId) {
        User user = Session.getUser();

        firstNameLabel.setText(user.getFirstName());
        lastNameLabel.setText(user.getLastName());
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

    public void firstNameChangeFailed() {
        JOptionPane.showMessageDialog(panel, "First name change failed", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void lastNameChangeFailed() {
        JOptionPane.showMessageDialog(panel, "Last name change failed", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
