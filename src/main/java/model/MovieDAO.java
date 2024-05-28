package com.list.project;

import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {

    private DatabaseConnection databaseConnection;

    public MovieDAO() {
        this.databaseConnection = new DatabaseConnection();
    }

    // Create

    public void addMovie(Movie movie) throws SQLException {
        String query = "INSERT INTO movies (title, genre, duration, poster, synopsis) VALUES ('" + movie.getTitle() + "', '" + movie.getGenre() + "', " + movie.getDuration() + ", '" + movie.getPoster() + "', '" + movie.getSynopsis() + "')";
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
        String query = "SELECT * FROM movies WHERE movie_id = " + id;

        ResultSet resultSet = databaseConnection.executeQuery(query);

        if (resultSet.next()) {
            String title = resultSet.getString("title");
            MovieGenre genre = MovieGenre.fromDisplayName(resultSet.getString("genre"));
            int duration = resultSet.getInt("duration");
            Image poster = (Image) resultSet.getObject("image");
            String synopsis = resultSet.getString("synopsis");

            movie = new Movie(id, title, genre, duration, poster, synopsis);
        }

        
        return movie;
    }

    public List<Movie> getAllMovies() throws SQLException {
        String query = "SELECT * FROM movies";
        int id;
        String title;
        MovieGenre genre;
        int duration;
        Image poster;
        String synopsis;
        List<Movie> movies = new ArrayList<>();

        ResultSet resultSet = databaseConnection.executeQuery(query);

        while (resultSet.next()) {
            id = resultSet.getInt("movie_id");
            title = resultSet.getString("title");
            genre = MovieGenre.fromDisplayName(resultSet.getString("genre")); 
            duration = resultSet.getInt("duration");
            poster = (Image) resultSet.getObject("image");
            synopsis = resultSet.getString("synopsis");

            movies.add(new Movie(id, title, genre, duration, poster, synopsis));
        }

        return movies;
    }
}
