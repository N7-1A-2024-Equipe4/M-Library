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
        List<Library> libraries = libraryDAO.getByUserId(id);
        //List<Movie> movies = movieDAO.getByLibraryId(library.getId());
        //library.setMovies(movies);
        return libraries;
    }

}
