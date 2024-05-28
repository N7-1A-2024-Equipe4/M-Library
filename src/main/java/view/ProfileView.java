package view;

import controller.ProfileController;
import dao.UserDAO;
import model.User;
import session.Session;

import javax.swing.*;

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
        changePasswordButton.addActionListener(actionEvent -> controller.passwordAction("newPassword"));
    }

    @Override
    public JPanel getPanel() {
        return this.panel;
    }

    @Override
    public void update() {
        User user = UserDAO.getUserByUsername(Session.getUsername());
        usernameLabel.setText(user.getUsername());
        passwordLabel.setText(user.getPassword());
    }

    public void usernameChangeSuccess(String username) {
        JOptionPane.showMessageDialog(panel, "Username changed successfully to " + username, "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}
