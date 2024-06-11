package controller;

import dao.MovieDAO;
import view.ViewEnum;
import view.home.HomeView;


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
