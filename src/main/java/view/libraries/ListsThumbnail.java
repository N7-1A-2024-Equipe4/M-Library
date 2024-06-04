package view.libraries;

import model.Movie;
import utils.ImageUtil;

import javax.swing.*;
import java.awt.*;
import model.Library;

public class ListsThumbnail extends JPanel{
    private final int WIDTH = 50;
    private final int HEIGHT = 50;

    private String libraryName;
    private JLabel titleLabel;
    private JLabel posterLabel;

    public ListsThumbnail(Library library) {
        this.libraryName = library.getName();
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        titleLabel = new JLabel(libraryName, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));

        posterLabel = new JLabel();
        posterLabel.setHorizontalAlignment(SwingConstants.CENTER);

        /*if (movie.getPoster() != null) {
            posterLabel.setIcon(new ImageIcon(ImageUtil.getScaledImage(movie.getPoster().getImage(), WIDTH, HEIGHT)));
        }*/

        add(titleLabel, BorderLayout.NORTH);
        add(posterLabel, BorderLayout.CENTER);
    }
}
