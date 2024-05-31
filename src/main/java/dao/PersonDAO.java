package dao;

import model.Person;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PersonDAO extends DAO<Person> {

    public PersonDAO() {
        super();
    }

    @Override
    public void add(Person person) throws SQLException {
        String query = "INSERT INTO person (person_id, first_name, last_name, date_of_birth, date_of_death, is_actor, is_director, is_screenwriter) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = databaseConnection.prepareStatement(query)) {
            stmt.setInt(1, person.getId());
            stmt.setString(2, person.getFirstName());
            stmt.setString(3, person.getLastName());
            stmt.setDate(4, person.getSqlDateOfBirth());
            stmt.setDate(5, person.getSqlDateOfDeath());
            stmt.setBoolean(6, person.isActor());
            stmt.setBoolean(7, person.isDirector());
            stmt.setBoolean(8, person.isScreenwriter());

            stmt.executeUpdate();
        }
    }

    @Override
    public List<Person> getAll() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public Person getById(int id) throws SQLException {
        Person person = null;
        String query = "SELECT * FROM person WHERE person_id = " + id;

        ResultSet resultSet = databaseConnection.executeQuery(query);

        if (resultSet.next()) {
            person = getPersonFromResultSet(resultSet);
        }

        return person;
    }

    @Override
    public void update(int id, Person entity) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(int id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    private Person getPersonFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("person_id");
        String firstName = resultSet.getString("first_name");
        String lastName = resultSet.getString("last_name");
        Date dateOfBirth = resultSet.getDate("date_of_birth");
        Date dateOfDeath = resultSet.getDate("date_of_death");
        Boolean isActor = resultSet.getBoolean("is_actor");
        Boolean isDirector = resultSet.getBoolean("is_director");
        Boolean isScreenwriter = resultSet.getBoolean("is_screenwriter");

        return new Person(id, firstName, lastName, dateOfBirth, dateOfDeath, isActor, isDirector, isScreenwriter);
    }
    

}
