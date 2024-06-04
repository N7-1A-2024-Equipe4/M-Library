package view;

import controller.ListsController;
import dao.LibraryDAO;
import dao.MovieDAO;
import model.Movie;
import view.home.MoviesGrid;
import model.Library;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class ListsView implements View {
    private final ListsController controller;
    private JPanel panel;
    private final LibraryDAO libraryDAO;

    public ListsView() {
        this.libraryDAO = new LibraryDAO();
        this.controller = new ListsController();
        setupUI();
    }

    private void setupUI(){
        panel = new JPanel(new BorderLayout());
        ListsGrid listsGrid = new ListsGrid();
        JScrollPane scrollPane = new JScrollPane(listsGrid, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        panel.add(scrollPane, BorderLayout.CENTER);
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public void refresh(Integer movieID) {
        try {
            List<Library> libraries = LibraryDAO.getAll();
            listsGrid.setMovies(movies);
        } catch (SQLException exception) {
            // ...
        }
    }

}
