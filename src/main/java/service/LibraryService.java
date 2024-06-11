package service;

import java.sql.SQLException;
import java.util.List;

import dao.LibraryDAO;
import dao.MovieDAO;
import dao.UserDAO;
import model.Library;

public class LibraryService {

    LibraryDAO libraryDAO;
    UserDAO userDAO;

    public LibraryService() {
        this.libraryDAO = new LibraryDAO();
        this.userDAO = new UserDAO();
    }

    public List<Library> getByUserId(int id) throws SQLException {
        return libraryDAO.getByUserId(id);
    }

    public Library getById(int id) throws SQLException {
        Library library = libraryDAO.getById(id);
        if(library != null){
            library.setOwner(this.userDAO.getById(library.getOwner().getId()));
        }
        return library;
    }

}
