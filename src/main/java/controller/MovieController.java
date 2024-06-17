package controller;

import model.Library;
import service.LibraryService;

public class MovieController {

    public MovieController() {
    }

    public void addMovieToLibraryAction(Library library, int movieId, String note) {
        LibraryService libraryService = new LibraryService();
        libraryService.addMovieToLibrary(library.getId(), movieId, note);

    }
}
