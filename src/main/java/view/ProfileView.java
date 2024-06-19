package view;

import controller.ProfileController;
import model.User;
import service.SessionService;
import service.UserService;

import javax.swing.*;

public class ProfileView implements View {
    private final ProfileController controller;
    private final UserService userService;
    private User user;
    private JPanel panel;
    private JLabel usernameLabel;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton editButton;
    private JPanel editPanel;
    private JButton saveButton;
    private JLabel creationDateLabel;
    private JLabel fullNameLabel;
    private JLabel profilePictureLabel;
    private JButton showLibrariesButton;

    public ProfileView() {
        this.controller = new ProfileController(this);
        this.userService = new UserService();
        this.editButton.addActionListener(e -> editPanel.setVisible(!editPanel.isVisible())); // toggle
        this.saveButton.addActionListener(e -> controller.saveChangesAction(
                firstNameField.getText(),
                lastNameField.getText(),
                usernameField.getText(),
                String.valueOf(passwordField.getPassword())
        ));
        this.showLibrariesButton.addActionListener(e -> controller.showLibrariesAction(user.getId()));
    }

    @Override
    public JPanel getPanel() {
        return this.panel;
    }

    @Override
    public void refresh(Integer userId) {
        if (userId == null || userId.equals(SessionService.getActiveUserId())) {
            // logged in user's profile
            user = SessionService.getUser();
            editButton.setVisible(true);
            firstNameField.setText(user.getFirstName());
            lastNameField.setText(user.getLastName());
            usernameField.setText(user.getUsername());
            passwordField.setText("");
        } else {
            // visiting another user's profile
            user = userService.getUser(userId);
            editButton.setVisible(false);
        }
        fullNameLabel.setText(user.getFirstName() + " " + user.getLastName().toUpperCase());
        usernameLabel.setText(user.getUsername());
        profilePictureLabel.setIcon(user.getPicture());
        firstNameLabel.setText(user.getFirstName());
        lastNameLabel.setText(user.getLastName());
        creationDateLabel.setText(user.getCreatedAt().toString());
        editPanel.setVisible(false);
    }

    public void userChangeSuccess() {
        JOptionPane.showMessageDialog(panel, "User modification successful", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public void userChangeFail() {
        JOptionPane.showMessageDialog(panel, "User modification failed", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
