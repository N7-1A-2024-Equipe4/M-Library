package model;

import java.util.Date;
import java.util.List;

public class Person {

    private int id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Date dateOfDeath;
    private Boolean isActor = false;
    private List<Movie> actedMovies;
    private Boolean isDirector = false;
    private List<Movie> directedMovies;
    private Boolean isScreenwriter = false;
    private List<Movie> writtenMovies;

    
    public Person(int id, String firstName, String lastName, Date dateOfBirth, Date dateOfDeath, Boolean isActor, Boolean isDirector, Boolean isScreenwriter) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.isActor = isActor;
        this.isDirector = isDirector;
        this.isScreenwriter = isScreenwriter;
    }

    public Person(String firstName, String lastName, Date dateOfBirth, Date dateOfDeath, Boolean isActor, Boolean isDirector, Boolean isScreenwriter) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.isActor = isActor;
        this.isDirector = isDirector;
        this.isScreenwriter = isScreenwriter;
    }

    public Person(int id, String firstName, String lastName, Date dateOfBirth, Date dateOfDeath) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
    }

    public Person(String firstName, String lastName, Date dateOfBirth, Date dateOfDeath) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
    }

    public Person(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(int id) {
        this.id = id;
    }

    // Setters and Getters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(Date dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public Boolean getIsActor() {
        return isActor;
    }

    public void setIsActor(Boolean isActor) {
        this.isActor = isActor;
    }

    public List<Movie> getActedMovies() {
        return actedMovies;
    }

    public void setActedMovies(List<Movie> actedMovies) {
        this.actedMovies = actedMovies;
    }

    public Boolean getIsDirector() {
        return isDirector;
    }

    public void setIsDirector(Boolean isDirector) {
        this.isDirector = isDirector;
    }

    public List<Movie> getDirectedMovies() {
        return directedMovies;
    }

    public void setDirectedMovies(List<Movie> directedMovies) {
        this.directedMovies = directedMovies;
    }

    public Boolean getIsScreenwriter() {
        return isScreenwriter;
    }

    public void setIsScreenwriter(Boolean isScreenwriter) {
        this.isScreenwriter = isScreenwriter;
    }

    public List<Movie> getWrittenMovies() {
        return writtenMovies;
    }

    public void setWrittenMovies(List<Movie> writtenMovies) {
        this.writtenMovies = writtenMovies;
    }

    // Add methods for movie lists

    public void addActedMovie(Movie movie) {
        actedMovies.add(movie);
    }

    public void addDirectedMovie(Movie movie) {
        directedMovies.add(movie);
    }

    public void addWrittenMovie(Movie movie) {
        writtenMovies.add(movie);
    }
}
