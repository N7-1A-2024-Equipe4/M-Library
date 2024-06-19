package view.home;

import model.Movie;
import view.thumbnail.MovieThumbnail;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MoviesGrid extends JPanel {
    public MoviesGrid() {
        setLayout(new GridLayout(0, 5, 5, 5));
    }

    public void setMovies(List<Movie> movies) {
        removeAll();

        for (Movie movie : movies) {
            MovieThumbnail thumbnail = new MovieThumbnail(movie);
            this.add(thumbnail);
        }
    }
}
