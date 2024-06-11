package controller;

import dao.LibraryDAO;
import view.ViewEnum;
import view.libraries.ListsView;

public class ListsController {
    private final ListsView view;

    private final LibraryDAO libraryDAO;

    public ListsController(ListsView view) {
        this.view = view;
        this.libraryDAO = new LibraryDAO();
    }

    public void showDetails(int libraryId) {
        MainController.getInstance().show(ViewEnum.LIST, libraryId);
    }
}
