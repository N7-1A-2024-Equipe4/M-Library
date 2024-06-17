package view.search;

import controller.SearchController;
import model.Movie;
import model.User;
import view.View;
import view.thumbnail.MovieThumbnail;
import view.thumbnail.UserThumbnail;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class SearchView implements View {
    private final SearchController controller;
    private JPanel panel;
    private JTextField searchField;
    private JButton searchButton;
    private MovieSearchGrid movieSearchGrid;
    private JScrollPane moviesScrollPane;
    private UserSearchGrid userSearchGrid;
    private JScrollPane usersScrollPane;

    public SearchView() {
        this.controller = new SearchController(this);
        this.searchButton.addActionListener(e -> controller.searchAction(searchField.getText()));

        movieSearchGrid = new MovieSearchGrid();
        moviesScrollPane.setViewportView(movieSearchGrid);
        movieSearchGrid.addMouseListener(new MoviesGridListener());

        userSearchGrid = new UserSearchGrid();
        usersScrollPane.setViewportView(userSearchGrid);
        userSearchGrid.addMouseListener(new UsersGridListener());
    }

    public void setMovies(List<Movie> movies) {
        movieSearchGrid.setMovies(movies);
        refresh(null);
    }

    public void setUsers(List<User> users) {
        userSearchGrid.setUsers(users);
        refresh(null);
    }

    private class MoviesGridListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            Component component = movieSearchGrid.getComponentAt(e.getPoint());
            if (component instanceof MovieThumbnail clickedMovie) { // java 17 pattern matching
                controller.showMovieDetailsView(clickedMovie.getMovieId());
            }
        }
    }

    private class UsersGridListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            Component component = userSearchGrid.getComponentAt(e.getPoint());
            if (component instanceof UserThumbnail clickedUser) { // java 17 pattern matching
                controller.showUserProfileView(clickedUser.getUserId());
            }
        }
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public void refresh(Integer modelId) {
        panel.revalidate();
        panel.repaint();
    }
}
