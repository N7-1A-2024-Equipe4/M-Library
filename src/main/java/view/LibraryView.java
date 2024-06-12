package view;

import model.ElementOfLibrary;
import model.Library;
import model.Movie;
import service.LibraryService;
import utils.image.ImageUtil;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class LibraryView implements View {
    private JPanel mainPanel;
    private JPanel informationsPanel;
    private JPanel movieListPanel;
    private JPanel presentationPanel;
    private JPanel descriptionPanel;
    private JPanel movieIconPanel;
    private JLabel titleLabel;
    private JLabel authorLabel;
    private JLabel creationDateLabel;
    private JLabel descriptionTitleLabel;
    private JLabel descriptionLabel;
    private JLabel movieIconLabel;
    private JPanel panelInfoLibrary;
    private JPanel mainPanelDisplayMovies;

    private final int WIDTH = 150;
    private final int HEIGHT = 200;

    private LibraryService libraryService;

    public LibraryView() {
        this.libraryService = new LibraryService();
        setupUI();
    }

    private void setupUI() {
        presentationPanel.setPreferredSize(new Dimension(mainPanel.getWidth(), HEIGHT));
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
            titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
            creationDateLabel.setText(library.getDate().toString());
            authorLabel.setText("Created by " + library.getOwner().getFirstName() + " " + library.getOwner().getLastName());
            descriptionLabel.setText(library.getDescription());
            descriptionTitleLabel.setFont(new Font("Arial", Font.BOLD, 20));
            displayMovies(library);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void displayMovies(Library library) {
        /*foreach movie_in_libray
                create JPanel (gridLayout)
                        -> 1 flowLayout pr titleLabel
                        -> 1 JPanel avec gridLayout
                            => Une colonne Icon
                            => Une colonne avec deux labels (review et note)
         */
        try{
            libraryService.setElementsOfLibraries(library);
            List<ElementOfLibrary> movieToDisplay = library.getElements();
            for(ElementOfLibrary element : movieToDisplay) {
                System.out.println(element.getMovie().getTitle());
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
