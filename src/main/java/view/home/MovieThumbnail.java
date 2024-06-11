package view.home;


import javax.swing.*;
import java.awt.*;



import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import model.Movie;
import utils.image.ImageUtil;

public class MovieThumbnail extends JPanel {
    private final int WIDTH = 200;
    private final int HEIGHT = 300;

    private int movieId;
    private JLabel titleLabel;
    private JLabel posterLabel;

    public MovieThumbnail(Movie movie) {
        this.movieId = movie.getId();
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        titleLabel = new JLabel(movie.getTitle(), SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));

        posterLabel = new JLabel();
        posterLabel.setHorizontalAlignment(SwingConstants.CENTER);

        if (movie.getPoster() != null) {
            posterLabel.setIcon(new ImageIcon(ImageUtil.getScaledImage(movie.getPoster().getImage(), WIDTH, HEIGHT)));
        }

        add(titleLabel, BorderLayout.NORTH);
        add(posterLabel, BorderLayout.CENTER);
    }


    public int getMovieId() {
        return movieId;
    }
}