package dao;

import model.ElementOfLibrary;
import model.Library;
import model.User;
import utils.image.ImageUtil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.swing.ImageIcon;

public class LibraryDAO extends DAO<Library> {

    public LibraryDAO() {
        super();
    }

    @Override
    public void add(Library library) throws SQLException {
        String query = "INSERT INTO library (library_name, icon, creation_date, user_id, description) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = databaseConnection.prepareStatement(query)) {
            stmt.setString(1, library.getName());
            stmt.setBytes(2, library.getPosterBytes());
            stmt.setDate(3, new java.sql.Date(library.getCreationDate().getTime()));
            stmt.setInt(4, library.getOwner().getId());
            stmt.setString(5, library.getDescription());

            stmt.executeUpdate();
        }

    }

    @Override
    public List<Library> getAll() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public Library getById(int id) throws SQLException {
        String query = "SELECT * FROM library WHERE library_id = ?";
        Library library = null;
        try (PreparedStatement stmt = databaseConnection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            resultSet.next();
            library = getLibraryFromResultSet(resultSet);
        }
        return library;
    }

    public List<Library> getByUserId(int userId) throws SQLException {
        String query = "SELECT * FROM library WHERE user_id = ?";
        List<Library> libraries = new ArrayList<>();
        try (PreparedStatement stmt = databaseConnection.prepareStatement(query)) {
            stmt.setInt(1, userId);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                libraries.add(getLibraryFromResultSet(resultSet));
            }
        }
        return libraries;
    }

    @Override
    public void update(int id, Library entity) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(int id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    private Library getLibraryFromResultSet(ResultSet resultSet) throws SQLException {
        int libraryId = resultSet.getInt("library_id");
        String name = resultSet.getString("library_name");
        Date date = resultSet.getDate("creation_date");
        int userId = resultSet.getInt("user_id");
        String description = resultSet.getString("description");

        InputStream is =  resultSet.getBinaryStream("icon");
        ImageIcon icon;
        if (is != null) {
            try {
                icon = ImageUtil.getImageFromBinaryStream(is);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            icon = null;
        }
        return new Library(libraryId, name, new User(userId), description, icon, date);
    }

    public Map<Integer, String> getElementsOfLibrary(int libraryId) throws SQLException {
        Map<Integer, String> elements = new HashMap<>();
        String query = "SELECT * FROM movie_in_library WHERE library_id = ?";
        try (PreparedStatement stmt = databaseConnection.prepareStatement(query)) {
            stmt.setInt(1, libraryId);
            ResultSet resultSet = stmt.executeQuery();
            while(resultSet.next()){
                int movieId = resultSet.getInt("movie_id");
                String note = resultSet.getString("note");
                elements.put(movieId, note);
            }
        }
        return elements;
    }
}
