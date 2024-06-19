package view.movie;

import controller.MovieController;
import dao.ReviewDAO;
import model.Library;
import model.Movie;
import model.Person;
import model.Review;
import model.User;
import org.apache.commons.lang3.StringUtils;
import service.LibraryService;
import service.MovieService;
import service.SessionService;
import utils.image.ImageUtil;
import utils.TimeUtils;
import view.View;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MovieView implements View {
    private final int WIDTH = 200;
    private final int HEIGHT = 300;

    private final MovieController controller;
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
    private JButton doAReview;
    private JPanel reviewPanel;
    private JComboBox addMovieToLibraryComboBox;
    private JButton addMovieToLibraryButton;
    private JTextField AddMovieToLibraryNoteText;
    private JLabel addMovieToLibraryLabel;
    private Map<String, Library> libraryMap;

    private final MovieService movieService;
    private final ReviewDAO reviewDAO;

    private final LibraryService libraryService;
    private final SimpleDateFormat dateFormat;

    public MovieView() {
        this.controller = new MovieController(this);
        this.movieService = new MovieService();
        this.reviewDAO = new ReviewDAO();

        doAReview.addActionListener(e -> {
            openReviewForm();
        });
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
            Movie fetchedMovie = movieService.getMovieById(movieID);
            movie = fetchedMovie;

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

            List<Review> reviews = reviewDAO.getByMovieId(movieID);
            populateReviewPanel(reviews);
            setupAddToLibrary();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setupAddToLibrary() throws SQLException {
        if (SessionService.isLoggedIn()) {
            addMovieToLibraryLabel.setText("Add the movie to one of your libraries:");
            addMovieToLibraryComboBox.setVisible(true);
            addMovieToLibraryButton.setVisible(true);
            AddMovieToLibraryNoteText.setVisible(true);
            AddMovieToLibraryNoteText.setText("");
            List<Library> libraries = libraryService.getByUserIdComplete(SessionService.getUser().getId());

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

    private void populateReviewPanel(List<Review> reviews) {
        reviewPanel.removeAll();
        reviewPanel.setLayout(new BoxLayout(reviewPanel, BoxLayout.Y_AXIS));

        if (reviews == null || reviews.isEmpty()) {
            JLabel noReviewsLabel = new JLabel("No reviews available");
            Font synopsisFont = movieSynopsis.getFont();
            noReviewsLabel.setFont(synopsisFont);
            reviewPanel.add(noReviewsLabel);
        } else {
            for (Review review : reviews) {
                ReviewView reviewView = new ReviewView(review);
                reviewPanel.add(reviewView);
                reviewPanel.add(Box.createVerticalStrut(3));
            }
        }

        reviewPanel.revalidate();
        reviewPanel.repaint();
    }



    private void openReviewForm() {
        if (SessionService.isLoggedIn()) {
            User currentUser = SessionService.getUser();

            JFrame reviewFrame = new JFrame("Submit a Review");
            reviewFrame.setSize(300, 200);
            reviewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JPanel reviewPanel = new JPanel();
            reviewPanel.setLayout(new BoxLayout(reviewPanel, BoxLayout.Y_AXIS));

            JTextField reviewField = new JTextField();
            JSpinner ratingSpinner = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 10.0, 0.1));

            JButton submitButton = new JButton("Submit");

            submitButton.addActionListener(e -> {
                Number ratingValue = (Number)ratingSpinner.getValue();
                float rating = ratingValue.floatValue();
                controller.submitReview(reviewField.getText(), rating, currentUser, movie);
                refresh(movie.getId());

                reviewFrame.setVisible(false);
            });

            reviewPanel.add(new JLabel("Review:"));
            reviewPanel.add(reviewField);
            reviewPanel.add(new JLabel("Rating:"));
            reviewPanel.add(ratingSpinner);
            reviewPanel.add(submitButton);

            reviewFrame.add(reviewPanel);
            reviewFrame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(panel, "You need to be logged in to submit a review.");
        }
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
