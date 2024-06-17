package view.search;

import model.Movie;
import view.thumbnail.MovieThumbnail;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MovieSearchGrid extends JPanel {
    public MovieSearchGrid() {
        setLayout(new GridLayout(0, 5, 5, 5));
    }

    public void setMovies(List<Movie> movies) {
        removeAll();

        for (Movie movie : movies) {
            MovieThumbnail thumbnail = new MovieThumbnail(movie, 100, 150);
            this.add(thumbnail);
        }
    }
}
