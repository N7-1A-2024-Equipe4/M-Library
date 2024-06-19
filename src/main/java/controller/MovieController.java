package controller;

import model.Library;
import service.LibraryService;
import view.MovieView;

import dao.ReviewDAO;
import model.Movie;
import model.Review;
import model.User;

import java.sql.SQLException;

public class MovieController {
    private final MovieView view;
    private final ReviewDAO reviewDAO;
    public MovieController(MovieView view) {
        this.view = view;
        this.reviewDAO = new ReviewDAO();
    }
    private final ReviewDAO reviewDAO;

    public void addMovieToLibraryAction(Library library, int movieId, String note) {
        System.out.println("Adding movie to library");
        LibraryService libraryService = new LibraryService();
        libraryService.addMovieToLibrary(library.getId(), movieId, note);
        view.refresh(movieId);
    }

    public void submitReview(String review, float rating, User user, Movie movie) {
        try {

            Review reviewModel = new Review(review, rating, user, movie);
            reviewDAO.add(reviewModel);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to submit review", e);
        }
    }

}
