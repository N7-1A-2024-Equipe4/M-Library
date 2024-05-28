package controller;

import dao.MovieDAO;
import model.Movie;
import model.MovieGenre;
import view.HomeView;

import java.awt.*;

public class HomeController {

    private final HomeView view;

    private final MovieDAO movieDAO;

    public HomeController(HomeView view) {
        this.view = view;
        this.movieDAO = new MovieDAO();
    }

    public void addMovieAction(String title, MovieGenre genre, int duration, Image poster, String synopsis) {
        try {
            movieDAO.addMovie(new Movie(title, genre, duration, poster, synopsis));
            view.refresh();
        } catch (Exception e) {
            view.addMovieError("Error adding movie");
        }
    }

    public void removeMovieAction(int id) {

    }
}
