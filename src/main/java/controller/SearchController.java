package controller;

import model.Movie;
import model.User;
import service.MovieService;
import service.UserService;
import view.ViewEnum;
import view.search.SearchView;

import javax.swing.*;
import java.util.List;

public class SearchController {
    private final SearchView view;

    private final MovieService movieService;

    private final UserService userService;

    public SearchController(SearchView view) {
        this.view = view;
        this.movieService = new MovieService();
        this.userService = new UserService();
    }

    public void searchAction(String query) {
        // Fetch movies and users in parallel
        movieFetchWorker(query).execute();
        userFetchWorker(query).execute();
    }

    private SwingWorker<List<User>, Void> userFetchWorker(String query) {
        return new SwingWorker<>() {
            @Override
            protected List<User> doInBackground() {
                return userService.searchUsers(query);
            }

            @Override
            protected void done() {
                try {
                    view.setUsers(get());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private SwingWorker<List<Movie>, Void> movieFetchWorker(String query) {
        return new SwingWorker<>() {
            @Override
            protected List<Movie> doInBackground() {
                return movieService.searchMoviesByTitle(query);
            }

            @Override
            protected void done() {
                try {
                    view.setMovies(get());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public void showMovieDetailsView(int movieId) {
        MainController.getInstance().show(ViewEnum.MOVIE, movieId);
    }

    public void showUserProfileView(int userId) {
        MainController.getInstance().show(ViewEnum.PROFILE, userId);
    }
}
