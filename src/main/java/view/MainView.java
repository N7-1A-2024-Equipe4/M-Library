package view;

import controller.MainController;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * Main view of the application.<br>
 * Contains the navbar and the content panel.<br>
 * Singleton class.
 *
 * @see NavbarView
 * @see MainController
 */
public class MainView implements View {
    private static MainView instance;
    private final MainController controller;
    private JPanel panel;
    private NavbarView navbarView;
    private JPanel content;
    private final CardLayout contentLayout;

    public MainView() {
        controller = MainController.initInstance(this);
        contentLayout = (CardLayout) content.getLayout();

        // add different views to content panel layout
        Arrays.stream(ViewEnum.values()).forEach(
                viewEnum -> content.add(controller.getView(viewEnum).getPanel(), viewEnum.name())
        );

        // refresh navbar
        navbarView.refresh(null);
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }

    public void setContent(ViewEnum viewEnum) {
        contentLayout.show(content, viewEnum.name());
    }

    @Override
    public void refresh(Integer modelId) {
        navbarView.refresh(null);
    }

}
