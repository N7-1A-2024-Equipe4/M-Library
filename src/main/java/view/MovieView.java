package view;

import controller.MovieController;

import javax.swing.*;

public class MovieView implements View {
    private final MovieController controller;
    private JPanel panel;

    public MovieView() {
        controller = new MovieController();
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public void refresh() {

    }
}
