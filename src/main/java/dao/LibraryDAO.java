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
    public Library add(Library library) throws SQLException {
        String query = "INSERT INTO library (library_name, icon, creation_date, user_id, description) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = databaseConnection.prepareStatement(query)) {
            stmt.setString(1, library.getName());
            stmt.setBytes(2, library.getPosterBytes());
            stmt.setDate(3, new java.sql.Date(library.getCreationDate().getTime()));
            stmt.setInt(4, library.getOwner().getId());
            stmt.setString(5, library.getDescription());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating library failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    library.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating library failed, no ID obtained.");
                }
            }
            return library;
        }
    }

    @Override
    public List<Library> getAll() throws SQLException {
        String query = "SELECT * FROM library";
        List<Library> libraries = new ArrayList<>();
        try (PreparedStatement stmt = databaseConnection.prepareStatement(query)) {
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                libraries.add(getLibraryFromResultSet(resultSet));
            }
        }
        return libraries;
    }

    @Override
    public Library getById(int id) throws SQLException {
        String query = "SELECT * FROM library WHERE library_id = ?";
        Library library = null;
        try (PreparedStatement stmt = databaseConnection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                library = getLibraryFromResultSet(resultSet);
            } else {
                return null;
            }
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
        String query = "DELETE FROM movie_in_library WHERE library_id = ?";

        try (PreparedStatement stmt = databaseConnection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
        query = "DELETE FROM library WHERE library_id = ?";

        try (PreparedStatement stmt = databaseConnection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
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

    public void addMovieToLibrary(int libraryId, int movieId, String note) throws SQLException {
        String query = "INSERT INTO movie_in_library (movie_id, library_id, note) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = databaseConnection.prepareStatement(query)) {
            stmt.setInt(1, movieId);
            stmt.setInt(2, libraryId);
            stmt.setString(3, note);

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating movie in library failed, no rows affected.");
            }
        }
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
