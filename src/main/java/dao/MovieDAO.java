package dao;

import model.Movie;
import model.MovieGenre;
import utils.ImageUtil;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO extends DAO<Movie> {

    public MovieDAO() {
        super();
    }
  
    // Create
    @Override
    public void add(Movie movie) throws SQLException {
        String query = "INSERT INTO movie (title, genre, duration, image, synopsis) VALUES (?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = databaseConnection.prepareStatement(query)) {
            stmt.setString(1, movie.getTitle());
            stmt.setString(2, movie.getGenre().toString());
            stmt.setInt(3, movie.getDuration());
            stmt.setNull(4, java.sql.Types.BINARY);
            stmt.setString(5, movie.getSynopsis());

            stmt.executeUpdate();
        }
    }

    // Read
    @Override
    public Movie getById(int id) throws SQLException {
        Movie movie = null;
        String query = "SELECT * FROM movie WHERE movie_id = ?"; 

        try (PreparedStatement stmt = databaseConnection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                movie = getMovieFromResultSet(resultSet);
            }
        }

        return movie;
    }

    @Override
    public List<Movie> getAll() throws SQLException {
        String query = "SELECT * FROM movie";
        Movie movie = null;
        List<Movie> movies = new ArrayList<>();

        try (PreparedStatement stmt = databaseConnection.prepareStatement(query)) {
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                movie = getMovieFromResultSet(resultSet);
                movies.add(movie);
            }
        }


        return movies;
    }        

    // Update

    @Override
    public void update(int id, Movie entity) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    // Delete
    @Override
    public void delete(int id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    // Other

    private Movie getMovieFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("movie_id");
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

        return new Movie(id, title, genre, duration, poster, synopsis);

    }
}
