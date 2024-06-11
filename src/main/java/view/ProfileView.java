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
    }

    @Override
    public JPanel getPanel() {
        return this.panel;
    }

    @Override
    public void refresh(Integer modelId) {
        User user;
        if (modelId == null) {
            user = Session.getUser();
        } else {
            user = userService.getUser(modelId);
        }
        fullNameLabel.setText(user.getFirstName() + " " + user.getLastName().toUpperCase());
        usernameLabel.setText(user.getUsername());
        // profilePictureLabel.setIcon(new ImageIcon(user.getProfilePicture())); TODO
        firstNameLabel.setText(user.getFirstName());
        lastNameLabel.setText(user.getLastName());
        creationDateLabel.setText(user.getCreatedAt().toString());
        this.editPanel.setVisible(false);
        firstNameField.setText(user.getFirstName());
        lastNameField.setText(user.getLastName());
        usernameField.setText(user.getUsername());
        passwordField.setText("");
    }

    public void userChangeSuccess() {
        JOptionPane.showMessageDialog(panel, "User modification successful", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public void userChangeFail() {
        JOptionPane.showMessageDialog(panel, "User modification failed", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
