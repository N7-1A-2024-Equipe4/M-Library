package dao;

import model.Library;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
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
    

}
