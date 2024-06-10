package controller;

import dao.MovieDAO;
import model.Movie;
import model.MovieGenre;
import view.ViewEnum;
import view.home.HomeView;

import javax.swing.*;
import java.awt.*;

public class HomeController {

    private final HomeView view;

    private final MovieDAO movieDAO;

    public HomeController(HomeView view) {
        this.view = view;
        this.movieDAO = new MovieDAO();
    }

    public void showDetails(Integer movieID) {
        MainController.getInstance().show(ViewEnum.MOVIE, movieID);
    }
}
