package view;

import model.ElementOfLibrary;
import model.Library;
import service.LibraryService;
import service.SessionService;
import utils.image.ImageUtil;

import javax.sql.rowset.BaseRowSet;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;
import controller.LibraryController;

public class LibraryView implements View {
    private JPanel mainPanel;
    private JPanel movieListPanel;
    private final LibraryController controller;

    private final int WIDTH = 200;
    private final int HEIGHT = 200;

    private final LibraryService libraryService;

    public LibraryView() {
        this.libraryService = new LibraryService();
        this.controller = new LibraryController(this);
        setupUI();
    }

    private void setupUI() {
        this.mainPanel = new JPanel(new BorderLayout());
    }

    @Override
    public JPanel getPanel() {
        return mainPanel;
    }

    @Override
    public void refresh(Integer modelId) {
        try {
            mainPanel.removeAll();

            JPanel informationsPanel = new JPanel();
            informationsPanel.setLayout(new BoxLayout(informationsPanel, BoxLayout.Y_AXIS));

            JPanel presentationPanel = new JPanel();
            presentationPanel.setLayout(new BoxLayout(presentationPanel, BoxLayout.Y_AXIS));

            JPanel movieIconPanel = new JPanel(new BorderLayout());
            JLabel movieIconLabel = new JLabel();
            Library library = this.libraryService.getById(modelId);
            if (library.getIcon() != null) {
                movieIconLabel.setIcon(new ImageIcon(ImageUtil.getScaledImage(library.getIcon().getImage(), WIDTH, HEIGHT)));
            }
            movieIconPanel.add(movieIconLabel, BorderLayout.CENTER);

            JPanel panelInfoLibrary = new JPanel();
            JPanel borderPanelForInfoLibrary = new JPanel(new BorderLayout());
            panelInfoLibrary.setLayout(new BoxLayout(panelInfoLibrary, BoxLayout.Y_AXIS));
            JLabel titleLabel = new JLabel();
            JLabel creationDateLabel = new JLabel();
            JLabel authorLabel = new JLabel();
            panelInfoLibrary.add(titleLabel);
            panelInfoLibrary.add(creationDateLabel);
            panelInfoLibrary.add(authorLabel);
            borderPanelForInfoLibrary.add(panelInfoLibrary, BorderLayout.WEST);

            presentationPanel.add(movieIconPanel);
            presentationPanel.add(borderPanelForInfoLibrary);

            JPanel borderPanelForDescription = new JPanel(new BorderLayout());
            JPanel descriptionPanel = new JPanel();
            descriptionPanel.setLayout(new BoxLayout(descriptionPanel, BoxLayout.Y_AXIS));

            JLabel descriptionTitleLabel = new JLabel("Description");
            JLabel descriptionLabel = new JLabel();
            JButton buttonDelete = new JButton(("Delete library"));
            if (library.getOwner().getId() == SessionService.getActiveUserId()) {
                // logged in user's profile
                buttonDelete.setVisible(true);
            } else {
                // visiting another user's profile
                buttonDelete.setVisible(false);
            }
            buttonDelete.addActionListener(e -> controller.deleteLibraryAction(modelId));
            JLabel moviesLabel = new JLabel("Movies");
            moviesLabel.setFont(new Font("Arial", Font.BOLD, 20));

            descriptionPanel.add(descriptionTitleLabel);
            descriptionPanel.add(descriptionLabel);
            descriptionPanel.add(buttonDelete);
            descriptionPanel.add(moviesLabel);
            borderPanelForDescription.add(descriptionPanel);

            informationsPanel.add(presentationPanel);
            informationsPanel.add(borderPanelForDescription);

            titleLabel.setText(library.getName());
            titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
            creationDateLabel.setText(library.getDate().toString());
            authorLabel.setText("Created by " + library.getOwner().getFirstName() + " " + library.getOwner().getLastName());
            descriptionLabel.setText(library.getDescription());
            descriptionTitleLabel.setFont(new Font("Arial", Font.BOLD, 20));

            movieListPanel = new JPanel(new GridLayout(0,1, 0,20));
            displayMovies(library);
            JPanel mainPanelForScroll = new JPanel();
            mainPanelForScroll.setLayout(new BoxLayout(mainPanelForScroll, BoxLayout.Y_AXIS));
            mainPanelForScroll.add(informationsPanel);
            mainPanelForScroll.add(movieListPanel);
            JScrollPane mainScrollPain = new JScrollPane(mainPanelForScroll, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            mainScrollPain.getVerticalScrollBar().setUnitIncrement(16);
            mainPanel.add(mainScrollPain, BorderLayout.CENTER);
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
                titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
                titlePanel.add(titleLabel, BorderLayout.WEST);

                JPanel movieInformationsPanel = new JPanel();
                movieInformationsPanel.setLayout(new BoxLayout(movieInformationsPanel, BoxLayout.Y_AXIS));

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
                ratingLabel.setFont(new Font("Arial", Font.BOLD,14));
                noteLabel.setFont(new Font("Arial", Font.PLAIN,16));
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
