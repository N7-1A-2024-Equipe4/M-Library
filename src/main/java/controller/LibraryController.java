package controller;

import service.LibraryService;
import view.LibraryView;
import view.ViewEnum;

public class LibraryController {
    private final LibraryView view;
    private final LibraryService libraryService;

    public LibraryController(LibraryView view) {
        this.view = view;
        this.libraryService = new LibraryService();
    }

    public void deleteLibraryAction(int libraryId) {
        MainController.getInstance().show(ViewEnum.LIBRARIES, 1);
        libraryService.deleteLibrary(libraryId);
    }
        
    

}
