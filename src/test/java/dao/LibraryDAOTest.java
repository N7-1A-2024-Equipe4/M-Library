package dao;

import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

public class LibraryDAOTest {
    private LibraryDAO dao;

    @Before
    public void setUp() throws Exception {
        dao = new LibraryDAO();
    }

    @Test
    public void getByUserIdTest() {
        try {
            assert(dao.getById(99999) == null);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
