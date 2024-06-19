package controller;

import model.Library;
import org.junit.Before;
import service.LibraryService;
import org.junit.Test;
import session.Session;
import view.MovieView;

import java.util.List;

public class MovieControllerTest {
    private  MovieController controller;
    private  LibraryService libraryService ;

    @Before
    public void setUp() {
        controller = new MovieController(new MovieView());
        libraryService = new LibraryService();
    }

    @Test
    public void testAddMovieToLibraryAction() {
        try {
            Session.login("a", "a");
            List<Library> libraries = libraryService.getByUserIdComplete(Session.getUser().getId());

            assert(libraries.contains(libraries.get(0)));
            controller.addMovieToLibraryAction(libraries.get(0), 10, "This is a test note that should be deleted");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
