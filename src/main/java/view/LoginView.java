package view;

import controller.LoginController;

import javax.swing.*;

public class LoginView extends View {
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
    public void update() {

    }
}
