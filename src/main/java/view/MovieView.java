package view;

import controller.MovieController;
import model.Library;
import model.Movie;
import model.Person;
import org.apache.commons.lang3.StringUtils;
import service.LibraryService;
import service.MovieService;
import session.Session;
import utils.image.ImageUtil;
import utils.TimeUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MovieView implements View {
    private final MovieController controller;

    private final int WIDTH = 200;
    private final int HEIGHT = 250;

    private Movie movie;
    private JPanel panel;
    private JLabel movieImage;
    private JLabel movieTitle;
    private JLabel movieGenre;
    private JLabel movieDuration;
    private JLabel movieRating;
    private JLabel movieSynopsis;
    private JLabel movieDirectors;
    private JPanel movieCastingPanel;
    private JComboBox addMovieToLibraryComboBox;
    private JButton addMovieToLibraryButton;
    private JTextField AddMovieToLibraryNoteText;
    private JLabel addMovieToLibraryLabel;
    private Map<String, Library> libraryMap;

    private final MovieService movieService;
    private final LibraryService libraryService;
    private final SimpleDateFormat dateFormat;

    public MovieView() {
        this.controller = new MovieController(this);
        this.movieService = new MovieService();
        this.libraryService = new LibraryService();
        this.libraryMap = new HashMap<>();
        this.addMovieToLibraryButton.addActionListener(e -> controller.addMovieToLibraryAction(
                libraryMap.get(addMovieToLibraryComboBox.getSelectedItem()),
                movie.getId(),
                AddMovieToLibraryNoteText.getText()
        ));
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public void refresh(Integer movieID) {
        try {
            movie = movieService.getMovieById(movieID);

            if (movie.getPoster() != null) {
                movieImage.setIcon(new ImageIcon(ImageUtil.getScaledImage(movie.getPoster().getImage(), WIDTH, HEIGHT)));
            }

            // Set movie details
            movieTitle.setText(movie.getTitle());
            movieGenre.setText(StringUtils.capitalize(movie.getGenre().toString().toLowerCase()));
            movieDuration.setText(TimeUtils.formatDuration(movie.getDuration()));
            movieSynopsis.setText(movie.getSynopsis());
            movieRating.setText(Float.toString(movie.getRating()));
            movieDirectors.setText(formatDirectors(movie.getDirectors()));
            populateCastingPanel(movie.getActors());

            setupAddToLibrary();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setupAddToLibrary() throws SQLException {
        if (Session.isLoggedIn()) {
            addMovieToLibraryLabel.setText("Add the movie to one of your libraries:");
            addMovieToLibraryComboBox.setVisible(true);
            addMovieToLibraryButton.setVisible(true);
            AddMovieToLibraryNoteText.setVisible(true);
            AddMovieToLibraryNoteText.setText("");
            List<Library> libraries = libraryService.getByUserIdComplete(Session.getUser().getId());

            // Add movie to library
            addMovieToLibraryComboBox.removeAllItems();
            for (Library library : libraries) {
                if (library.getMovies().stream().noneMatch(m -> m.getId() == movie.getId())) {
                    libraryMap.put(library.getName(), library);
                    addMovieToLibraryComboBox.addItem(library.getName());
                }
            }
            addMovieToLibraryComboBox.setSelectedIndex(-1);
        } else {
            addMovieToLibraryLabel.setText("Please log in to add movie to library");
            addMovieToLibraryComboBox.setVisible(false);
            addMovieToLibraryButton.setVisible(false);
            AddMovieToLibraryNoteText.setVisible(false);
        }
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

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
