package view.libraries;

import controller.ListsController;
import dao.LibraryDAO;
import dao.LibraryService;
import model.*;
import view.View;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import session.Session;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListsView implements View {
    private final ListsController controller;
    private JPanel panel;
    private final LibraryDAO libraryDAO;
    private final LibraryService libraryService;
    private ListsGrid listsGrid;

    public ListsView() {
        this.libraryService = new LibraryService();
        this.libraryDAO = new LibraryDAO();
        this.controller = new ListsController(this);
        setupUI();
    }

    private void setupUI(){
        panel = new JPanel(new BorderLayout());
        this.listsGrid = new ListsGrid();
        listsGrid.addMouseListener(new ListsGridListener());
        JLabel pageTitle = new JLabel("My libraries");
        pageTitle.setFont(new Font("Arial", Font.BOLD, 24));
        JScrollPane scrollPane = new JScrollPane(listsGrid, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        panel.add(pageTitle, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public void refresh() {
        try {
            List<Library> libraries = this.libraryService.getByUserId(Session.getUser().getId());
            this.listsGrid.setLists(libraries);
        } catch (SQLException exception) {
            //
        }
    }

    private class ListsGridListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            ListsThumbnail clickedList = (ListsThumbnail)((JPanel)e.getSource()).getComponentAt(e.getPoint());
            controller.showDetails(clickedList.getLibraryName());
        }
    }
}
