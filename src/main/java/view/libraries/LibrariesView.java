package view.libraries;

import controller.LibrariesController;
import model.Library;
import model.User;
import service.LibraryService;
import service.SessionService;
import service.UserService;
import view.View;
import view.thumbnail.LibrariesThumbnail;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

public class LibrariesView implements View {
    private final LibrariesController controller;
    private final LibraryService libraryService;
    private final UserService userService;
    private JPanel panel;
    private LibrariesGrid listsGrid;
    private JButton createLibraryButton;
    private JLabel pageTitle;


    public LibrariesView() {
        this.controller = new LibrariesController(this);
        this.libraryService = new LibraryService();
        this.userService = new UserService();
        setupUI();
    }

    private void setupUI() {
        panel = new JPanel(new BorderLayout());
        this.listsGrid = new LibrariesGrid();
        listsGrid.addMouseListener(new ListsGridListener());
        createLibraryButton = new JButton("Create Library");
        createLibraryButton.addActionListener(actionEvent -> controller.
                goToLibraryCreationAction());

        pageTitle = new JLabel("My libraries");
        pageTitle.setFont(new Font("Arial", Font.BOLD, 24));
        JScrollPane scrollPane = new JScrollPane(listsGrid, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        panel.add(pageTitle, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(createLibraryButton, BorderLayout.EAST);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public void refresh(Integer userId) {
        try {
            List<Library> libraries;
            if (userId == null || userId == SessionService.getActiveUserId()) {
                // logged in user's libraries
                libraries = libraryService.getByUserId(SessionService.getActiveUserId());
                pageTitle.setText("My libraries");
            } else {
                // visiting another user's libraries
                libraries = libraryService.getByUserId(userId);
                User user = userService.getUser(userId);
                pageTitle.setText("Libraries of " + user.getFirstName() + " " + user.getLastName());
            }
            this.listsGrid.setLists(libraries);
        } catch (SQLException exception) {
            //
        }
    }

    private class ListsGridListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            LibrariesThumbnail clickedList = (LibrariesThumbnail) ((JPanel) e.getSource()).getComponentAt(e.getPoint());
            controller.showDetails(clickedList.getId());
        }
    }
}
