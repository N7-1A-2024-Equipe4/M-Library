package controller;

import model.Library;
import service.LibraryService;
import view.MovieView;

public class MovieController {
    private final MovieView view;
    public MovieController(MovieView view) {
        this.view = view;
    }

    public void addMovieToLibraryAction(Library library, int movieId, String note) {
        LibraryService libraryService = new LibraryService();
        libraryService.addMovieToLibrary(library.getId(), movieId, note);
        view.refresh(movieId);
    }
}
