package controller;

import dao.LibraryDAO;
import view.ViewEnum;
import view.libraries.LibrariesView;

public class LibrariesController {
    private final LibrariesView view;

    private final LibraryDAO libraryDAO;

    public LibrariesController(LibrariesView view) {
        this.view = view;
        this.libraryDAO = new LibraryDAO();
    }

    public void showDetails(int libraryId) {
        MainController.getInstance().show(ViewEnum.LIBRARY, libraryId);
    }

    public void goToLibraryCreationAction() {
        MainController.getInstance().show(ViewEnum.CREATELIBRARY, 1);
    }

}
