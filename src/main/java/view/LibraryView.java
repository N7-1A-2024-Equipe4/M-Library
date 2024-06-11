package view;

import model.Library;
import service.LibraryService;
import utils.image.ImageUtil;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class LibraryView implements View {
    private JPanel mainPanel;
    private JPanel informationsPanel;
    private JPanel movieListPanel;
    private JPanel presentationPanel;
    private JPanel descriptionPanel;
    private JPanel crudPanel;
    private JPanel movieIconPanel;
    private JLabel titleLabel;
    private JLabel authorLabel;
    private JLabel creationDateLabel;
    private JLabel descriptionTitleLabel;
    private JLabel descriptionLabel;
    private JLabel movieIconLabel;

    private final int WIDTH = 150;
    private final int HEIGHT = 200;

    private LibraryService libraryService;

    public LibraryView() {
        this.libraryService = new LibraryService();
    }

    @Override
    public JPanel getPanel() {
        return mainPanel;
    }

    @Override
    public void refresh(Integer modelID) {
        try {
            Library library = this.libraryService.getById(modelID);
            if (library.getIcon() != null) {
                movieIconLabel.setIcon(new ImageIcon
                        (ImageUtil.getScaledImage(library.getIcon().getImage(),
                                WIDTH, HEIGHT)));
            }
            titleLabel.setText(library.getName());
            titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
            creationDateLabel.setText(library.getDate().toString());
            authorLabel.setText("Created by " + library.getOwner().getFirstName() + " " + library.getOwner().getLastName());
            descriptionLabel.setText(library.getDescription());
            descriptionTitleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
