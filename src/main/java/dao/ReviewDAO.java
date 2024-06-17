package dao;

import model.Movie;
import model.Review;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO extends DAO<Review> {

    private final UserDAO userDAO;

    public ReviewDAO() {
        super();
        this.userDAO = new UserDAO();
    }

    @Override
    public void add(Review review) throws SQLException {
        String query = "INSERT INTO review (review, user_id, movie_id, rating) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = databaseConnection.prepareStatement(query)) {
            stmt.setString(1, review.getReview());
            stmt.setInt(2, review.getAuthor().getId());
            stmt.setInt(3, review.getMovie().getId());
            stmt.setFloat(4, review.getRating());

            stmt.executeUpdate();
        }
    }

    @Override
    public List<Review> getAll() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public Review getById(int id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    public List<Review> getByMovieId(int movieId) throws SQLException {
        String query = "SELECT * FROM review WHERE movie_id = ?";
        List<Review> reviews = new ArrayList<>();
        try (PreparedStatement stmt = databaseConnection.prepareStatement(query)) {
            stmt.setInt(1, movieId);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                reviews.add(getReviewFromResultSet(resultSet));
            }
        }
        return reviews;
    }

    @Override
    public void update(int id, Review entity) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(int id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    private Review getReviewFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("review_id");
        String reviewText = resultSet.getString("review");
        int userId = resultSet.getInt("user_id");
        int movieId = resultSet.getInt("movie_id");
        float rating = resultSet.getFloat("rating");

        User author = userDAO.getById(userId);
        Movie movie = new Movie();

        return new Review(id, reviewText, rating, author, movie);
    }
}
