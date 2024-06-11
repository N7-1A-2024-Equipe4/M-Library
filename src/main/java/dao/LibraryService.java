package dao;

import java.sql.SQLException;

import model.Library;

public class LibraryService {

    private LibraryDAO libraryDAO;

    public LibraryService() {
        libraryDAO = new LibraryDAO();
    }

    public void addLibrary(Library library) {
        try {
            libraryDAO.add(library);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
