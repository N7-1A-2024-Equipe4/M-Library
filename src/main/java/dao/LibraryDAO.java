package dao;

import model.Library;
import model.User;
import utils.ImageUtil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;

public class LibraryDAO extends DAO<Library> {

    public LibraryDAO() {
        super();
    }

    @Override
    public void add(Library library) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
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

    public Library getByUserId(int userId) throws SQLException {
        String query = "SELECT * FROM library WHERE user_id = ?";
        Library library = null;

        try (PreparedStatement stmt = databaseConnection.prepareStatement(query)) {
            stmt.setInt(1, userId);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                library = getLibraryFromResultSet(resultSet);
            }

        }

        return library;
    
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
        ImageIcon icon = null;
        if (is != null) {
            try {
                icon = ImageUtil.getImageFromBinaryStream(is);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            icon = null;
        }

        return new Library(libraryId, name, new User(userId), description, icon);
    }

    

}
