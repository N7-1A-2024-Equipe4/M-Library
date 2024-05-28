package model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MovieList {
    private List<Movie> movies;

    private String listName;

    public MovieList() {
        this.movies = new ArrayList<>();
    }

    public List<Movie> getMovies() {
        return new ArrayList<>(movies);
    }

    public void setMovies(List<Movie> movies) {
        this.movies = new ArrayList<>(movies);
    }

    public void add(Movie movie) {
        movies.add(movie);
    }

    public void remove(Movie movie) {
        movies.remove(movie);
    }

    public void remove(String id) {
        movies.removeIf(movie -> movie.getId().equals(id));
    }

    public void removeIf(Predicate<Movie> predicate) {
        movies.removeIf(predicate);
    }
}
