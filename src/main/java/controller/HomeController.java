package controller;

import dao.MovieDAO;
import model.Movie;
import view.HomeView;

public class HomeController {

    private final HomeView view;

    public HomeController(HomeView view) {
        this.view = view;
    }

    public void addMovieAction(Movie movie) {
        MovieDAO.create(new Movie("movie", "genre", 2000));
        view.update();
    }

    public void removeMovieAction(String id) {

    }
}
