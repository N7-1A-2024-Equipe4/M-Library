package view;

import controller.MovieController;
import model.Movie;
import model.Person;
import org.apache.commons.lang3.StringUtils;
import service.MovieService;
import utils.TimeUtils;
import utils.image.ImageUtil;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

public class MovieView implements View {
    private final MovieController controller;

    private final int WIDTH = 200;
    private final int HEIGHT = 300;

    private JPanel panel;
    private JLabel movieImage;
    private JLabel movieTitle;
    private JLabel movieGenre;
    private JLabel movieDuration;
    private JLabel movieRating;
    private JLabel movieSynopsis;
    private JLabel movieDirectors;
    private JPanel movieCastingPanel;

    private final MovieService movieService;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public MovieView() {
        controller = new MovieController();
        this.movieService = new MovieService();
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public void refresh(Integer movieId) {
        Movie fetchedMovie = movieService.getMovieById(movieId);
        if (fetchedMovie == null) {
            return;
        }
        if (fetchedMovie.getPoster() != null) {
            movieImage.setIcon(new ImageIcon(ImageUtil.getScaledImage(fetchedMovie.getPoster().getImage(), WIDTH, HEIGHT)));
        }

        movieTitle.setText(fetchedMovie.getTitle());
        movieGenre.setText(StringUtils.capitalize(fetchedMovie.getGenre().toString().toLowerCase()));
        movieDuration.setText(TimeUtils.formatDuration(fetchedMovie.getDuration()));
        movieSynopsis.setText(fetchedMovie.getSynopsis());
        movieRating.setText(Float.toString(fetchedMovie.getRating()));
        movieDirectors.setText(formatDirectors(fetchedMovie.getDirectors()));
        populateCastingPanel(fetchedMovie.getActors());

    }

    private String formatDirectors(List<Person> directors) {
        if (directors == null || directors.isEmpty()) {
            return "Unknown";
        }
        return directors.stream()
                .map(director -> director.getFirstName() + " " + director.getLastName())
                .collect(Collectors.joining(", "));
    }

    private String formatActorDetails(Person actor) {
        StringBuilder details = new StringBuilder();
        details.append(actor.getFirstName()).append(" ").append(actor.getLastName());
        if (actor.getDateOfBirth() != null) {
            details.append(" (").append(dateFormat.format(actor.getDateOfBirth()));
            if (actor.getDateOfDeath() != null) {
                details.append(" - ").append(dateFormat.format(actor.getDateOfDeath()));
            }
            details.append(")");
        }
        return details.toString();
    }

    private void populateCastingPanel(List<Person> actors) {
        movieCastingPanel.removeAll();
        movieCastingPanel.setLayout(new BoxLayout(movieCastingPanel, BoxLayout.Y_AXIS));

        Font synopsisFont = movieSynopsis.getFont();
        if (actors == null || actors.isEmpty()) {
            JLabel noActorsLabel = new JLabel("No actors available");
            noActorsLabel.setFont(synopsisFont);
            movieCastingPanel.add(noActorsLabel);
        } else {
            for (Person actor : actors) {
                JLabel actorLabel = new JLabel(formatActorDetails(actor));
                actorLabel.setFont(synopsisFont);
                movieCastingPanel.add(actorLabel);
                movieCastingPanel.add(Box.createVerticalStrut(3));
            }
        }
        movieCastingPanel.revalidate();
        movieCastingPanel.repaint();
    }

}
