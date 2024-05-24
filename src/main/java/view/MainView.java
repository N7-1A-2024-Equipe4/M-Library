package view;

import controller.MainController;

import javax.swing.*;
import java.awt.*;

/**
 * Main view of the application.<br>
 * Contains the navbar and the content panel.<br>
 * Singleton class.
 *
 * @see NavbarView
 * @see MainController
 */
public class MainView {
    private static MainView instance = null;

    private final MainController controller;
    public JPanel panel;
    private NavbarView navbarView;
    private JPanel content;
    private final CardLayout contentLayout;

    private MainView() {
        controller = new MainController();
        contentLayout = (CardLayout) content.getLayout();

        // add different views to content panel layout
        content.add(new HomeView().panel, "home");
        content.add(new ListsView().panel, "lists");
        content.add(new ProfileView().panel, "profile");

        // show home view by default
        showHome();
    }

    public static MainView getInstance() {
        if (instance == null) {
            instance = new MainView();
        }
        return instance;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void showHome() {
        contentLayout.show(content, "home");
    }

    public void showLists() {
        contentLayout.show(content, "lists");
    }

    public void showProfile() {
        contentLayout.show(content, "profile");
    }
}
