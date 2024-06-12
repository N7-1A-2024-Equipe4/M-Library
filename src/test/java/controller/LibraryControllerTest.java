package controller;

import java.awt.Image;
import java.util.Date;

import javax.swing.ImageIcon;

import org.junit.Test;
import model.Library;
import model.User;
import service.LibraryService;
import session.Session;

public class LibraryControllerTest {
    private LibraryController controller;

    @Test
    public void testDeleteLibraryAction() {
        // Arrange
        LibraryService libraryService = new LibraryService();
        Library library = new Library("testLibrary",
                new ImageIcon("resources/library.png"),
                new Date(),
                new User(1),
                "testDescription");
        library = libraryService.addLibrary(library);

        // Act
        controller.deleteLibraryAction(library.getId());

        // Assert

    }
}