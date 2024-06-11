package view;

import model.Movie;
import service.LibraryService;
import model.Library;
import org.apache.commons.lang3.StringUtils;
import utils.ImageUtil;
import utils.TimeUtils;

import javax.swing.*;
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
    private JLabel creationDateLabel;
    private JLabel authorLabel;
    private JButton subscriptionButton;
    private JLabel descriptionTitleLabel;
    private JLabel descriptionLabel;
    private JLabel movieIconLabel;

    private final int WIDTH = 200;
    private final int HEIGHT = 250;

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
                movieIconLabel.setIcon(new ImageIcon(ImageUtil.getScaledImage(library.getIcon().getImage(), WIDTH, HEIGHT)));
            }
            titleLabel.setText(library.getName());
            creationDateLabel.setText(library.getDate().toString());
            authorLabel.setText(library.getOwner().getFirstName() + " " + library.getOwner().getLastName());
            descriptionLabel.setText(library.getDescription());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
