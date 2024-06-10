package view.libraries;

import model.Movie;
import lombok.Getter;
import utils.ImageUtil;

import javax.swing.*;
import java.awt.*;
import model.Library;

public class ListsThumbnail extends JPanel{
    private final int WIDTH = 200;
    private final int HEIGHT = 300;

    @Getter
    private String libraryName;
    private JLabel titleLabel;
    private JLabel posterLabel;

    public ListsThumbnail(Library library) {
        this.libraryName = library.getName();
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        titleLabel = new JLabel(libraryName, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));

        posterLabel = new JLabel();
        posterLabel.setHorizontalAlignment(SwingConstants.CENTER);
        if (library.getPoster() != null) {
            posterLabel.setIcon(new ImageIcon(ImageUtil.getScaledImage(library.getPoster().getImage(), WIDTH, HEIGHT)));
        }
        add(titleLabel, BorderLayout.NORTH);
        add(posterLabel, BorderLayout.CENTER);
    }

}
