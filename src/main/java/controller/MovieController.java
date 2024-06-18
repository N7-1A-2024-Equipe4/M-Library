package controller;

import dao.ReviewDAO;
import model.Movie;
import model.Review;
import model.User;

import java.sql.SQLException;

public class MovieController {
    private final ReviewDAO reviewDAO;

    public MovieController() {
        this.reviewDAO = new ReviewDAO();
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
