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
    public enum View {
        HOME,
        LISTS,
        PROFILE
    }

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
        content.add(new HomeView().panel, View.HOME.name());
        content.add(new ListsView().panel, View.LISTS.name());
        content.add(new ProfileView().panel, View.PROFILE.name());

        // show home view by default
        setCurrentView(View.HOME);
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

    public void setCurrentView(View view) {
        contentLayout.show(content, view.name());
    }
}
