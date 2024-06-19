package controller;

import model.Library;
import model.User;
import org.junit.Test;
import service.LibraryService;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Date;

public class LibraryControllerTest {
    private LibraryController controller;

    @Test
    public void testDeleteLibraryAction() {
        try {
            // Arrange
            LibraryService libraryService = new LibraryService();
            Library library = new Library("testLibrary",
                    new ImageIcon("resources/library.png"),
                    new Date(),
                    new User(1),
                    "testDescription");
            library = libraryService.addLibrary(library);
            assert (libraryService.getById(library.getId()) != null);

            // Act
            controller.deleteLibraryAction(library.getId());

            // Assert
            assert (libraryService.getById(library.getId()) == null);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}