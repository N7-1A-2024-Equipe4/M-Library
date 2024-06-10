package view;

import controller.MovieController;
import dao.MovieDAO;
import model.Movie;
import org.apache.commons.lang3.StringUtils;
import utils.ImageUtil;
import utils.TimeUtils;

import javax.swing.*;
import java.sql.SQLException;

public class MovieView implements View {
    private final MovieController controller;

    private final int WIDTH = 200;
    private final int HEIGHT = 250;


    private JPanel panel;
    private JLabel movieImage;
    private JLabel movieTitle;
    private JLabel movieGenre;
    private JLabel movieDuration;
    private JLabel movieRating;
    private JLabel movieSynopsis;

    private final MovieDAO movieDAO;

    public MovieView() {
        controller = new MovieController();
        this.movieDAO = new MovieDAO();
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public void refresh(Integer movieID) {
        System.out.println(movieID);

        try {
            Movie fetchedMovie = movieDAO.getById(movieID);
            if (fetchedMovie.getPoster() != null) {
                movieImage.setIcon(new ImageIcon(ImageUtil.getScaledImage(fetchedMovie.getPoster().getImage(), WIDTH, HEIGHT)));
            }

            movieTitle.setText(fetchedMovie.getTitle());
            movieGenre.setText(StringUtils.capitalize(fetchedMovie.getGenre().toString().toLowerCase()));
            movieDuration.setText(TimeUtils.formatDuration(fetchedMovie.getDuration()));
            movieSynopsis.setText(fetchedMovie.getSynopsis());
            movieRating.setText(Float.toString(fetchedMovie.getRating()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
