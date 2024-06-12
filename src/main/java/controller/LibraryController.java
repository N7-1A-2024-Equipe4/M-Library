package controller;

import dao.LibraryDAO;
import view.LibraryView;
import view.ViewEnum;
import service.LibraryService;
import view.libraries.LibrariesView;

public class LibraryController {
    private final LibraryView view;
    private final LibraryService libraryService;

    public LibraryController(LibraryView view) {
        this.view = view;
        this.libraryService = new LibraryService();
    }

    public void deleteLibraryAction(int libraryId) {
        MainController.getInstance().show(ViewEnum.LISTS, 1);
        libraryService.deleteLibrary(libraryId);
    }
        
    

}
