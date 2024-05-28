package view;

import controller.HomeController;
import model.MovieList;

import javax.swing.*;

public class HomeView implements View {
    private final HomeController controller;
    private JPanel panel;
    private JButton button1;
    private JButton a1Button;
    private JButton button3;

    public HomeView() {
        this.controller = new HomeController(this);
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public void refresh() {

    }

    protected void update(MovieList model) {
        // Update the view with the model data

    }

    public void addMovieError(String errorAddingMovie) {
        // Display error message
        JOptionPane.showMessageDialog(panel, errorAddingMovie, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
