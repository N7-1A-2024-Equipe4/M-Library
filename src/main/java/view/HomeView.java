package view;

import controller.HomeController;

import javax.swing.*;

public class HomeView {
    private final HomeController controller;
    JPanel panel;
    private JButton button1;
    private JButton a1Button;
    private JButton button3;

    public HomeView() {
        controller = new HomeController(this);
    }
}
