package view.home;

import controller.HomeController;
import dao.MovieDAO;
import model.Movie;
import model.MovieList;
import view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

public class HomeView implements View {
    private final HomeController controller;

    private JPanel panel;
    private MoviesGrid moviesGrid;

    private final MovieDAO movieDAO;

    public HomeView() {
        this.controller = new HomeController(this);
        this.movieDAO = new MovieDAO();
        setupUI();
    }

    private void setupUI() {
        panel = new JPanel(new BorderLayout());

        moviesGrid = new MoviesGrid();
        moviesGrid.addMouseListener(new MoviesGridListener());
        JScrollPane scrollPane = new JScrollPane(moviesGrid, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        panel.add(scrollPane, BorderLayout.CENTER);
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public void refresh(Integer movieID) {
        try {
            List<Movie> movies = movieDAO.getAll();
            moviesGrid.setMovies(movies);
        } catch (SQLException exception) {
            // ...
        }
    }

    protected void update(MovieList model) {
        // Update the view with the model data

    }

    public void addMovieError(String errorAddingMovie) {
        // Display error message
        JOptionPane.showMessageDialog(panel, errorAddingMovie, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private class MoviesGridListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            MovieThumbnail clickedMovie = (MovieThumbnail)((JPanel)e.getSource()).getComponentAt(e.getPoint());
            controller.showDetails(clickedMovie.getMovieId());
        }
    }

}
