package dao;

import model.Movie;

public class MovieDAO {
    public static Movie create(Movie movie) {
        return new Movie("newMovie", "newGenre", 2003);
    }
}
