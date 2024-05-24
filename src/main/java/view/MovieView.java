package view;

import controller.MovieController;

import javax.swing.*;

public class MovieView {
    private final MovieController controller;
    private JPanel panel;

    public MovieView() {
        controller = new MovieController();
    }
}
