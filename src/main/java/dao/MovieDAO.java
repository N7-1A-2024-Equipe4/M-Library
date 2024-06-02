package dao;

import model.Movie;
import model.MovieGenre;
import utils.ImageUtil;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {

    private DatabaseConnection databaseConnection;

    public MovieDAO() {
        this.databaseConnection = DatabaseConnection.getInstance();
    }

    // Create
    public void addMovie(Movie movie) throws SQLException {
        String query = "INSERT INTO movie (title, genre, duration, poster, synopsis) VALUES ('" + movie.getTitle() + "', '" + movie.getGenre() + "', " + movie.getDuration() + ", '" + movie.getPoster() + "', '" + movie.getSynopsis() + "')";
        databaseConnection.executeQuery(query);
    }

    // Update

    public void updateMovie(Movie movie) {
        // Implementation
    }

    // Delete

    public void deleteMovie(int id) {
        // Implementation
    }

    // Read

    public Movie findMovieById(int id) throws SQLException {
        Movie movie = null;
        String query = "SELECT * FROM movie WHERE movie_id = " + id;

        ResultSet resultSet = databaseConnection.executeQuery(query);

        if (resultSet.next()) {
            String title = resultSet.getString("title");
            MovieGenre genre = MovieGenre.fromDisplayName(resultSet.getString("genre"));
            int duration = resultSet.getInt("duration");

            InputStream is =  resultSet.getBinaryStream("image");
            ImageIcon poster = null;
            if (is != null) {
                try {
                    poster = ImageUtil.getImageFromBinaryStream(is);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                poster = null;
            }


            String synopsis = resultSet.getString("synopsis");

            movie = new Movie(id, title, genre, duration, null, synopsis);
        }


        return movie;
    }

    public List<Movie> getAllMovies() throws SQLException {
        String query = "SELECT * FROM movie";
        int id;
        String title;
        MovieGenre genre;
        int duration;
        ImageIcon poster;
        String synopsis;
        List<Movie> movies = new ArrayList<>();

        ResultSet resultSet = databaseConnection.executeQuery(query);

        while (resultSet.next()) {
            id = resultSet.getInt("movie_id");
            title = resultSet.getString("title");
            genre = MovieGenre.fromDisplayName(resultSet.getString("genre"));
            duration = resultSet.getInt("duration");

            InputStream is =  resultSet.getBinaryStream("image");
            if (is != null) {
                try {
                    poster = ImageUtil.getImageFromBinaryStream(is);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                poster = null;
            }

            synopsis = resultSet.getString("synopsis");

            movies.add(new Movie(id, title, genre, duration, poster, synopsis));
        }


        return movies;
    }
}
