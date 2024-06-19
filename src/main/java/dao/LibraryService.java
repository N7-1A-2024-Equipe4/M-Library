package dao;

import java.sql.SQLException;
import java.util.List;

import model.Library;
import model.Movie;

public class LibraryService {

    LibraryDAO libraryDAO = new LibraryDAO();
    MovieDAO movieDAO = new MovieDAO();

    public LibraryService() {
        // TODO Auto-generated constructor stub
    }

    public void addLibrary(Library library) {
        try {
            libraryDAO.add(library);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
