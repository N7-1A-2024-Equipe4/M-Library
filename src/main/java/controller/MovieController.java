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
        System.out.println("Adding movie to library");
        LibraryService libraryService = new LibraryService();
        libraryService.addMovieToLibrary(library.getId(), movieId, note);
        view.refresh(movieId);
    }
}
