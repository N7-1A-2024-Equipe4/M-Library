package model;

import java.sql.SQLException;
import java.util.List;

import dao.LibraryDAO;
import dao.MovieDAO;

public class LibraryService {

    LibraryDAO libraryDAO = new LibraryDAO();
    MovieDAO movieDAO = new MovieDAO();

    public LibraryService() {
        // TODO Auto-generated constructor stub
    }

    public Library getByUserId(int id) throws SQLException {
        Library library = libraryDAO.getByUserId(id);
        List<Movie> movies = movieDAO.getByLibraryId(library.getId());
        //library.setMovies(movies);
        return library;
    }

}
