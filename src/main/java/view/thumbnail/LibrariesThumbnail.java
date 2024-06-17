package view.thumbnail;

import lombok.Getter;
import model.Library;
import utils.image.ImageUtil;

import javax.swing.*;
import java.awt.*;

public class LibrariesThumbnail extends JPanel{
    @Getter
    private String libraryName;
    @Getter
    private int id;
    private JLabel titleLabel;
    private JLabel posterLabel;

    public LibrariesThumbnail(Library library) {
        this(library, 200, 200);
    }

    public LibrariesThumbnail(Library library, int width, int height) {
        this.libraryName = library.getName();
        this.id = library.getId();
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(width, height));

        titleLabel = new JLabel(libraryName, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));

        posterLabel = new JLabel();
        posterLabel.setHorizontalAlignment(SwingConstants.CENTER);
        if (library.getIcon() != null) {
            posterLabel.setIcon(new ImageIcon(ImageUtil.getScaledImage(library.getIcon().getImage(), width, height)));
        }
        add(titleLabel, BorderLayout.NORTH);
        add(posterLabel, BorderLayout.CENTER);
    }
}
