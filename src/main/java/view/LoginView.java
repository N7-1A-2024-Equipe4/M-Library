package view;

import controller.LoginController;

import javax.swing.*;
import java.awt.*;

public class LoginView implements View {
    private final LoginController controller;
    private JPanel panel;
    private JTextField usernameTextField;
    private JButton loginButton;

    public LoginView() {
        controller = new LoginController(this);
        loginButton.addActionListener(actionEvent -> controller.loginAction(usernameTextField.getText()));
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public void refresh() {

    }

    public void loginFailed() {
        usernameTextField.setText("");
        usernameTextField.setBorder(BorderFactory.createLineBorder(Color.RED));
        JOptionPane.showMessageDialog(panel, "Login failed", "Error", JOptionPane.ERROR_MESSAGE);
    }

}
