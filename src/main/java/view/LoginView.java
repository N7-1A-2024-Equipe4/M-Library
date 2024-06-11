package view;

import controller.LoginController;

import javax.swing.*;
import java.util.Set;

public class LoginView implements View {
    private final LoginController controller;
    private JPanel panel;
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    private JButton loginButton;

    public LoginView() {
        controller = new LoginController(this);
        loginButton.addActionListener(actionEvent -> controller.loginAction(
                usernameTextField.getText(),
                passwordTextField.getText()
        ));
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public void refresh(Integer moveID) {
        usernameTextField.setBorder(BorderFactory.createLineBorder(java.awt.Color.BLACK));
        passwordTextField.setBorder(BorderFactory.createLineBorder(java.awt.Color.BLACK));
    }

    public void loginFailed(Set<LoginError> errors) {
        refresh(null);
        String errorMessage = "Login failed:\n";
        if (errors.contains(LoginError.EMPTY_USERNAME)) {
            errorMessage += "Missing username\n";
            usernameTextField.setBorder(BorderFactory.createLineBorder(java.awt.Color.RED));
        }
        if (errors.contains(LoginError.EMPTY_PASSWORD)) {
            errorMessage += "Missing password\n";
            passwordTextField.setBorder(BorderFactory.createLineBorder(java.awt.Color.RED));
        }
        if (errors.contains(LoginError.WRONG_USERNAME_AND_PASSWORD)) {
            errorMessage += "Wrong username and password\n";
            usernameTextField.setBorder(BorderFactory.createLineBorder(java.awt.Color.RED));
            passwordTextField.setBorder(BorderFactory.createLineBorder(java.awt.Color.RED));
        }
        JOptionPane.showMessageDialog(panel, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public enum LoginError {
        EMPTY_USERNAME,
        EMPTY_PASSWORD,
        WRONG_USERNAME_AND_PASSWORD
    }
}
