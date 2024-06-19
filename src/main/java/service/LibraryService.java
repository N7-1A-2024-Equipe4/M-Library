package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dao.LibraryDAO;
import dao.MovieDAO;
import dao.UserDAO;
import model.ElementOfLibrary;
import model.Library;
import model.Movie;

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

    public Library getById(int id) throws SQLException {
        Library library = libraryDAO.getById(id);
        if(library != null){
            library.setOwner(this.userDAO.getById(library.getOwner().getId()));
        }
        return library;
    }

    public void setElementsOfLibraries(Library library) throws SQLException {
        Map<Integer, String> elements = libraryDAO.getElementsOfLibrary(library.getId());
        List<ElementOfLibrary> elementsOfLibraryList = new ArrayList<>();
        for(Map.Entry<Integer, String> entry : elements.entrySet()){
            elementsOfLibraryList.add(new ElementOfLibrary(movieDAO.getById(entry.getKey()), entry.getValue()));
        }
        library.setElements(elementsOfLibraryList);
    }
}
