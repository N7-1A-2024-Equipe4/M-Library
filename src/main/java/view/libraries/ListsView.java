package view.libraries;

import controller.ListsController;
import dao.LibraryDAO;
import model.*;
import view.View;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import session.Session;

public class ListsView implements View {
    private final ListsController controller;
    private JPanel panel;
    private final LibraryDAO libraryDAO;
    private ListsGrid listsGrid;

    public ListsView() {
        this.libraryDAO = new LibraryDAO();
        this.controller = new ListsController(this);
        setupUI();
    }

    private void setupUI(){
        panel = new JPanel(new BorderLayout());
        this.listsGrid = new ListsGrid();
        JScrollPane scrollPane = new JScrollPane(listsGrid, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        panel.add(new JLabel("My libraries"), BorderLayout.NORTH);
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
            List<Library> libraries = this.libraryDAO.getByUserId(Session.getUser().getId());
            /*List<Library> libraries = new ArrayList<Library>();//this.libraryDAO.getAll();
            List<ElementOfLibrary> el = new ArrayList<ElementOfLibrary>();
            el.add(new ElementOfLibrary(
                    new Movie("ede", MovieGenre.HORROR, 3, null, "rvdver")));
            libraries.add(new Library("test", el, new User()));
            libraries.add(new Library("test2", el, new User()));
            libraries.add(new Library("test3", el, new User()));
            libraries.add(new Library("rferfergerg", el, new User()));
            libraries.add(new Library("r", el, new User()));
            libraries.add(new Library("efergergergege", el, new User()));*/
            this.listsGrid.setLists(libraries);
        } catch (/*SQL*/Exception exception) {
            //
        }
    }
}
