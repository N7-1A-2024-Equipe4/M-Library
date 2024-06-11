package service;

import dao.MovieDAO;
import dao.PersonDAO;
import model.Movie;

import java.sql.SQLException;

public class MovieService {
    private final MovieDAO movieDAO;
    private final PersonDAO personDAO;

    public MovieService() {
        this.movieDAO = new MovieDAO();
        this.personDAO = new PersonDAO();
    }

    public Movie getMovieById(int id) throws SQLException {
        Movie movie = movieDAO.getById(id);
        if (movie != null) {
            movie.setActors(personDAO.getActorsForMovie(id));
            movie.setDirectors(personDAO.getDirectorsForMovie(id));
            movie.setScreenwriters(personDAO.getScreenwritersForMovie(id));
        }
        return movie;
    }
}
