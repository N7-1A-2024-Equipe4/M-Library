package dao;

import model.Movie;
import model.MovieGenre;
import utils.ImageUtil;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO extends DAO<Movie> {

    public MovieDAO() {
        super();
    }
    @Override
    public void add(Movie movie) throws SQLException {
        String query = "INSERT INTO movie (title, genre, duration, image, synopsis, rating) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = databaseConnection.prepareStatement(query)) {
            stmt.setString(1, movie.getTitle());
            stmt.setString(2, movie.getGenre().toString());
            stmt.setInt(3, movie.getDuration());
            stmt.setNull(4, java.sql.Types.BINARY);
            stmt.setString(5, movie.getSynopsis());
            stmt.setFloat(6, movie.getRating());

            stmt.executeUpdate();
        }
    }

    @Override
    public Movie getById(int id) throws SQLException {
        String query = "SELECT * FROM movie WHERE movie_id = ?";

        try (PreparedStatement stmt = databaseConnection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                return getMovieFromResultSet(resultSet);
            }
        }

        return null;
    }

    @Override
    public List<Movie> getAll() throws SQLException {
        String query = "SELECT * FROM movie";
        List<Movie> movies = new ArrayList<>();

        try (PreparedStatement stmt = databaseConnection.prepareStatement(query)) {
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                movies.add(getMovieFromResultSet(resultSet));
            }
        }


        return movies;
    }

    @Override
    public void update(int id, Movie entity) throws SQLException {
        String query = "UPDATE movie SET title = ?, genre = ?, duration = ?, image = ?, synopsis = ?, rating = ? WHERE movie_id = ?";

        try (PreparedStatement stmt = databaseConnection.prepareStatement(query)) {
            stmt.setString(1, entity.getTitle());
            stmt.setString(2, entity.getGenre().toString());
            stmt.setInt(3, entity.getDuration());
            stmt.setNull(4, java.sql.Types.BINARY);
            stmt.setString(5, entity.getSynopsis());
            stmt.setFloat(6, entity.getRating());
            stmt.setInt(7, id);

            stmt.executeUpdate();
        }
    }
    @Override
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM movie WHERE movie_id = ?";

        try (PreparedStatement stmt = databaseConnection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    private Movie getMovieFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("movie_id");
        String title = resultSet.getString("title");
        MovieGenre genre = MovieGenre.fromDisplayName(resultSet.getString("genre"));
        int duration = resultSet.getInt("duration");

        String posterUrl = resultSet.getString("image");
        ImageIcon poster = null;
        if (posterUrl != null && !posterUrl.isEmpty()) {
            try {
                poster = ImageUtil.getImageFromUrl(posterUrl);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        String synopsis = resultSet.getString("synopsis");
        float rating = resultSet.getFloat("rating");

        return new Movie(id, title, genre, duration, poster, synopsis, rating);
    }
}