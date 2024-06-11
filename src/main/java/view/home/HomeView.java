package view.home;

import controller.HomeController;
import dao.MovieDAO;
import model.Movie;
import view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class HomeView implements View {
    private final HomeController controller;

    private JPanel panel;
    private MoviesGrid moviesGrid;
    private JProgressBar progressBar;

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

        progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);
        progressBar.setVisible(false);

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(progressBar, BorderLayout.SOUTH);
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public void refresh(Integer movieID) {
        progressBar.setVisible(true);

        new SwingWorker<List<Movie>, Void>() {
            @Override
            protected List<Movie> doInBackground() throws SQLException {
                return movieDAO.getAll();
            }

            @Override
            protected void done() {
                try {
                    List<Movie> movies = get();
                    moviesGrid.setMovies(movies);
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                } finally {
                    progressBar.setVisible(false);
                }
            }
        }.execute();
    }

    public void addMovieError(String errorAddingMovie) {
        // Display error message
        JOptionPane.showMessageDialog(panel, errorAddingMovie, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private class MoviesGridListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            Component component = moviesGrid.getComponentAt(e.getPoint());
            if (component instanceof MovieThumbnail) {
                MovieThumbnail clickedMovie = (MovieThumbnail) component;
                controller.showDetails(clickedMovie.getMovieId());
            }
        }
    }
}
