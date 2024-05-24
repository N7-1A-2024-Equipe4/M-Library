package controller;

import dao.MovieDAO;
import model.Movie;
import model.MovieList;
import view.HomeView;

public class HomeController {

    private final HomeView view;
    private MovieList movieList;

    public HomeController(HomeView view) {
        this.view = view;
    }

    public void addMovieAction() {
        MovieDAO.create(new Movie("movie", "genre", 2000));
    }

    public void removeMovieAction() {
        movieList.remove("movie");
    }
}
