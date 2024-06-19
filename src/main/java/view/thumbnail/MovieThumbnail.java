package view.thumbnail;


import lombok.Getter;
import model.Movie;
import utils.image.ImageUtil;

import javax.swing.*;
import java.awt.*;

public class MovieThumbnail extends JPanel {

    @Getter
    private int movieId;
    private JLabel titleLabel;
    private JLabel posterLabel;

    public MovieThumbnail(Movie movie) {
        this(movie, 200, 300);
    }

    public MovieThumbnail(Movie movie, int width, int height) {
        this.movieId = movie.getId();
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(width, height));

        titleLabel = new JLabel(movie.getTitle(), SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));

        posterLabel = new JLabel();
        posterLabel.setHorizontalAlignment(SwingConstants.CENTER);

        if (movie.getPoster() != null) {
            posterLabel.setIcon(new ImageIcon(ImageUtil.getScaledImage(movie.getPoster().getImage(), width, height)));
        }

        add(titleLabel, BorderLayout.NORTH);
        add(posterLabel, BorderLayout.CENTER);
    }
}