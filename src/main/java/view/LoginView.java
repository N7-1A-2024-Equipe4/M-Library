package view;

import controller.LoginController;

import javax.swing.*;

public class LoginView implements View {
    private final LoginController controller;
    private JPanel panel;
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    private JButton loginButton;

    public LoginView() {
        controller = new LoginController(this);
        loginButton.addActionListener(actionEvent -> controller
                .loginAction(
                        usernameTextField.getText(),
                        passwordTextField.getText()
                ));
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public void refresh() {
        usernameTextField.setBorder(BorderFactory.createLineBorder(java.awt.Color.BLACK));
    }

    public void loginFailed() {
        usernameTextField.setBorder(BorderFactory.createLineBorder(java.awt.Color.RED));
        JOptionPane.showMessageDialog(panel, "Login failed", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
