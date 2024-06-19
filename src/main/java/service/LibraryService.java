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
    MovieDAO movieDAO;

    public LibraryService() {
        this.libraryDAO = new LibraryDAO();
        this.userDAO = new UserDAO();
        this.movieDAO = new MovieDAO();
    }

    public List<Library> getByUserId(int id) throws SQLException {
        return libraryDAO.getByUserId(id);
    }

    public List<Library> getByUserIdComplete(int id) throws SQLException {
        List<Library> libraries = libraryDAO.getByUserId(id);
        if (libraries != null) {
            for (Library library : libraries) {
                // set owner
                library.setOwner(this.userDAO.getById(library.getOwner().getId()));

                // set movies
                library.setMovies(this.movieDAO.getByLibraryId(library.getId()));
            }
        }
        return libraries;
    }

    public Library getById(int id) throws SQLException {
        Library library = libraryDAO.getById(id);
        if(library != null){
            library.setOwner(this.userDAO.getById(library.getOwner().getId()));
        }
        return library;
    }

    public Library getByIdComplete(int id) throws SQLException {
        Library library = libraryDAO.getById(id);
        if(library != null){
            // set owner
            library.setOwner(this.userDAO.getById(library.getOwner().getId()));

            // set movies
            library.setMovies(this.movieDAO.getByLibraryId(library.getId()));
        }
        return library;
    }

    public Library addLibrary(Library library) {
        try {
            return libraryDAO.add(library);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteLibrary(int id) {
        try {
            libraryDAO.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Library> getAll() {
        try {
            return libraryDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addMovieToLibrary(int libraryId, int movieId, String note) {
        try {
            libraryDAO.addMovieToLibrary(libraryId, movieId, note);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
