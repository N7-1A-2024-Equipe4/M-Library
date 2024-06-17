package controller;

import dao.ReviewDAO;
import model.Review;
import model.User;

import java.sql.SQLException;

public class MovieController {
    private final ReviewDAO reviewDAO;

    public MovieController() {
        this.reviewDAO = new ReviewDAO();
    }

    public void submitReview(String review, float rating, User user, int movie_id) {
        try {

            Review reviewModel = new Review(review, rating, user, movie_id);
            reviewDAO.add(reviewModel);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to submit review", e);
        }
    }
}
