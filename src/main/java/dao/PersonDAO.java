package dao;

import model.Library;
import model.Person;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO extends DAO<Person> {

    public PersonDAO() {
        super();
    }

    @Override
    public Library add(Person person) throws SQLException {
        String query = "INSERT INTO person (person_id, first_name, last_name, date_of_birth, date_of_death, is_actor, is_director, is_screenwriter) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = databaseConnection.prepareStatement(query)) {
            stmt.setInt(1, person.getId());
            stmt.setString(2, person.getFirstName());
            stmt.setString(3, person.getLastName());
            stmt.setDate(4, new java.sql.Date(person.getDateOfBirth().getTime()));
            stmt.setDate(5, new java.sql.Date(person.getDateOfDeath().getTime()));
            stmt.setBoolean(6, person.getIsActor());
            stmt.setBoolean(7, person.getIsDirector());
            stmt.setBoolean(8, person.getIsScreenwriter());

            stmt.executeUpdate();
        }
        return null;
    }

    @Override
    public Person getById(int id) throws SQLException {
        String query = "SELECT * FROM person WHERE person_id = ?";

        try (PreparedStatement stmt = databaseConnection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                return getPersonFromResultSet(resultSet);
            }
        }

        return null;
    }

    @Override
    public List<Person> getAll() throws SQLException {
        String query = "SELECT * FROM person";
        List<Person> persons = new ArrayList<>();

        try (PreparedStatement stmt = databaseConnection.prepareStatement(query)) {
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                persons.add(getPersonFromResultSet(resultSet));
            }
        }

        return persons;
    }

    @Override
    public void update(int id, Person entity) throws SQLException {
        String query = "UPDATE person SET first_name = ?, last_name = ?, date_of_birth = ?, date_of_death = ?, is_actor = ?, is_director = ?, is_screenwriter = ? WHERE person_id = ?";

        try (PreparedStatement stmt = databaseConnection.prepareStatement(query)) {
            stmt.setString(1, entity.getFirstName());
            stmt.setString(2, entity.getLastName());
            stmt.setDate(3, new java.sql.Date(entity.getDateOfBirth().getTime()));
            stmt.setDate(4, new java.sql.Date(entity.getDateOfDeath().getTime()));
            stmt.setBoolean(5, entity.getIsActor());
            stmt.setBoolean(6, entity.getIsDirector());
            stmt.setBoolean(7, entity.getIsScreenwriter());
            stmt.setInt(8, id);

            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM person WHERE person_id = ?";

        try (PreparedStatement stmt = databaseConnection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public List<Person> getActorsForMovie(int movieId) throws SQLException {
        return getPersonsForMovie("SELECT p.* FROM person p INNER JOIN actor_in_movie aim ON p.person_id = aim.person_id WHERE aim.movie_id = ?", movieId);
    }

    public List<Person> getDirectorsForMovie(int movieId) throws SQLException {
        return getPersonsForMovie("SELECT p.* FROM person p INNER JOIN director_of_movie dom ON p.person_id = dom.person_id WHERE dom.movie_id = ?", movieId);
    }

    public List<Person> getScreenwritersForMovie(int movieId) throws SQLException {
        return getPersonsForMovie("SELECT p.* FROM person p INNER JOIN screenwriter_of_movie som ON p.person_id = som.person_id WHERE som.movie_id = ?", movieId);
    }

    private List<Person> getPersonsForMovie(String query, int movieId) throws SQLException {
        List<Person> persons = new ArrayList<>();

        try (PreparedStatement stmt = databaseConnection.prepareStatement(query)) {
            stmt.setInt(1, movieId);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                persons.add(getPersonFromResultSet(resultSet));
            }
        }

        return persons;
    }

    private Person getPersonFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("person_id");
        String firstName = resultSet.getString("first_name");
        String lastName = resultSet.getString("last_name");
        java.sql.Date dateOfBirth = resultSet.getDate("date_of_birth");
        java.sql.Date dateOfDeath = resultSet.getDate("date_of_death");
        Boolean isActor = resultSet.getBoolean("is_actor");
        Boolean isDirector = resultSet.getBoolean("is_director");
        Boolean isScreenwriter = resultSet.getBoolean("is_screenwriter");

        return new Person(id, firstName, lastName, dateOfBirth, dateOfDeath, isActor, isDirector, isScreenwriter);
    }
}
