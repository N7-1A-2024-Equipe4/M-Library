package dao;

import java.sql.SQLException;
import java.util.List;

/**
 * The abstract DAO (Data Access Object) class provides a common interface for accessing and manipulating data in a database.
 *
 * @param <T> the type of entity being accessed or manipulated
 */
public abstract class DAO<T> {

    protected DatabaseConnection databaseConnection;

    /**
     * Constructs a DAO object.
     */
    public DAO() {
        this.databaseConnection = DatabaseConnection.getInstance();
    }

    // Create

    /**
     * Adds a new entity to the database.
     *
     * @param entity the entity to be added
     * @return
     * @throws SQLException if an error occurs while adding the entity
     */
    public abstract T add(T entity) throws SQLException;

    // Read

    /**
     * Retrieves all entities from the database.
     *
     * @return a list of all entities in the database
     * @throws SQLException if an error occurs while retrieving the entities
     */
    public abstract List<T> getAll() throws SQLException;

    /**
     * Retrieves an entity from the database by its ID.
     *
     * @param id the ID of the entity to be retrieved
     * @return the entity with the specified ID
     * @throws SQLException if an error occurs while retrieving the entity
     */
    public abstract T getById(int id) throws SQLException;

    // Update

    /**
     * Updates an existing entity in the database.
     *
     * @param entity the entity to be updated
     * @throws SQLException if an error occurs while updating the entity
     */
    public abstract void update(int id, T entity) throws SQLException;

    // Delete

    /**
     * Deletes an entity from the database by its ID.
     *
     * @param id the ID of the entity to be deleted
     * @throws SQLException if an error occurs while deleting the entity
     */
    public abstract void delete(int id) throws SQLException;

}
