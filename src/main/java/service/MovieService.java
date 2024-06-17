package service;

import dao.MovieDAO;
import dao.PersonDAO;
import model.Movie;

import java.sql.SQLException;
import java.util.List;

public class MovieService {
    private final MovieDAO movieDAO;
    private final PersonDAO personDAO;

    public MovieService() {
        this.movieDAO = new MovieDAO();
        this.personDAO = new PersonDAO();
    }

    public Movie getMovieById(int id) {
        Movie movie;
        try {
            movie = movieDAO.getById(id);
            if (movie != null) {
                movie.setActors(personDAO.getActorsForMovie(id));
                movie.setDirectors(personDAO.getDirectorsForMovie(id));
                movie.setScreenwriters(personDAO.getScreenwritersForMovie(id));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return movie;
    }

    public List<Movie> searchMoviesByTitle(String title) {
        try {
            return movieDAO.findByTitle(title);
        } catch (SQLException e) {
            e.printStackTrace();
            return List.of();
        }
    }

    public List<Movie> getAll() {
        try {
            return movieDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return List.of();
        }
    }
}
