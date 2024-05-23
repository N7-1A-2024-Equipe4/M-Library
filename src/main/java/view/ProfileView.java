package view;

import controller.ProfileController;

import javax.swing.*;

public class ProfileView {
    private final ProfileController controller;
    JPanel panel;

    public ProfileView() {
        controller = new ProfileController(this);
    }
}
