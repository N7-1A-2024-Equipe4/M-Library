package controller;

import dao.LibraryDAO;
import view.libraries.ListsView;

public class ListsController {
    private final ListsView view;

    private final LibraryDAO libraryDAO;

    public ListsController(ListsView view) {
        this.view = view;
        this.libraryDAO = new LibraryDAO();
    }
}
