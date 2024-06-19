package view;

import model.ElementOfLibrary;
import model.Library;
import model.Movie;
import service.LibraryService;
import utils.image.ImageUtil;

import javax.swing.*;
import javax.swing.border.Border;
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
    private JScrollPane mainScrollPain;
    private JPanel mainPanelForScroll;
    private JButton deleteLibraryButton;

    private final int WIDTH = 200;
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
    public void refresh(Integer modelId) {
        try {
            Library library = this.libraryService.getById(modelId);
            if (library.getIcon() != null) {
                movieIconLabel.setIcon(new ImageIcon(ImageUtil.getScaledImage(library.getIcon().getImage(), WIDTH, HEIGHT)));
            }

            titleLabel.setText(library.getName());
            titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
            creationDateLabel.setText(library.getDate().toString());
            authorLabel.setText("Created by " + library.getOwner().getFirstName() + " " + library.getOwner().getLastName());
            descriptionLabel.setText(library.getDescription());
            descriptionTitleLabel.setFont(new Font("Arial", Font.BOLD, 20));

            mainPanel.setLayout(new GridLayout(0,1));
            movieListPanel = new JPanel(new GridLayout(0,1, 0,20));
            displayMovies(library);
            mainPanelForScroll = new JPanel();
            mainPanelForScroll.setLayout(new BoxLayout(mainPanelForScroll, BoxLayout.Y_AXIS));
            mainPanelForScroll.add(informationsPanel);
            mainPanelForScroll.add(movieListPanel);
            mainScrollPain = new JScrollPane(mainPanelForScroll, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            mainScrollPain.getVerticalScrollBar().setUnitIncrement(16);
            mainPanel.add(mainScrollPain);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void displayMovies(Library library) {
        try{
            libraryService.setElementsOfLibraries(library);
            List<ElementOfLibrary> movieToDisplay = library.getElements();
            for(ElementOfLibrary element : movieToDisplay) {
                JPanel mainPanelList = new JPanel();
                mainPanelList.setLayout(new BoxLayout(mainPanelList, BoxLayout.Y_AXIS));

                JPanel titlePanel = new JPanel(new BorderLayout());
                JLabel titleLabel = new JLabel(element.getMovie().getTitle());
                titlePanel.add(titleLabel, BorderLayout.WEST);

                JPanel movieInformationsPanel = new JPanel();
                movieInformationsPanel.setLayout(/*new GridLayout(1, 2, 0, 0)*/
                        new BoxLayout(movieInformationsPanel, BoxLayout.Y_AXIS));

                JLabel moviePosterLabel = new JLabel();
                if (element.getMovie().getPoster() != null) {
                    moviePosterLabel.setIcon(new ImageIcon(ImageUtil.getScaledImage(element.getMovie().getPoster().getImage(), WIDTH, HEIGHT)));
                }
                JPanel imagePanel = new JPanel(new BorderLayout());
                imagePanel.add(moviePosterLabel, BorderLayout.WEST);

                JPanel descriptionAndRatingPanel = new JPanel();
                descriptionAndRatingPanel.setLayout(new GridLayout(2, 1, 0, 0));
                JLabel ratingLabel = new JLabel(Float.toString(element.getMovie().getRating()));
                JLabel noteLabel = new JLabel(element.getNote());
                descriptionAndRatingPanel.add(noteLabel);
                descriptionAndRatingPanel.add(ratingLabel);

                movieInformationsPanel.add(imagePanel);
                movieInformationsPanel.add(descriptionAndRatingPanel);

                mainPanelList.add(titlePanel);
                mainPanelList.add(movieInformationsPanel);
                this.movieListPanel.add(mainPanelList);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
