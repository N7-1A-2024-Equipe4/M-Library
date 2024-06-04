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

    public List<Library> getByUserId(int id) throws SQLException {
        return libraryDAO.getByUserId(id);
    }

}
