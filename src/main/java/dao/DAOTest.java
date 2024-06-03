package dao;

import java.sql.SQLException;
import java.util.List;

import model.*;


// This is not a permanent class, when real test are implemented, this class will be deleted
public class DAOTest {
    public static void main(String[] args) {

        // Create a new PersonDAO object
        PersonDAO personDAO = new PersonDAO();

        // Create a new MovieDAO object
        MovieDAO movieDAO = new MovieDAO();

        // Test the PersonDAO
        personTest(personDAO);

        // Test the MovieDAO
        movieTest(movieDAO);

    }

    public static void personTest(PersonDAO personDAO) {
        // Create a new Person object
        // Person person = new Person("99", "Robert", "Downey Jr.", new Date(1965, 4, 4), 
    }

    public static void movieTest(MovieDAO movieDAO) {
        // Create a new Movie object
        Movie movie = new Movie("BBgame", MovieGenre.ACTION, 181, "The Avengers take a final stand against Thanos in the epic conclusion of the Infinity Saga.");

        // Test the add method
        addMovie(movieDAO, movie);

        // Test the read methods
        
        //getAllMovies(movieDAO);
        
        getMovieById(movieDAO, 1);

        // Test the update method

        // Test the delete method
    }

    public static void addMovie(MovieDAO movieDAO, Movie movie) {
        try {
            movieDAO.add(movie);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getAllMovies(MovieDAO movieDAO) {
        try {
            List<Movie> movies = movieDAO.getAll();
            for (Movie movie : movies) {
                System.out.print("ID: " + movie.getId());
                System.out.print(" | Title: " + movie.getTitle());
                System.out.print(" | Genre: " + movie.getGenre());
                System.out.print(" | Duration: " + movie.getDuration());
                System.out.print(" | Poster: " + movie.getPoster());
                System.out.println(" | Synopsis: " + movie.getSynopsis());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void getMovieById(MovieDAO movieDAO, int id) {
        try {
            Movie movie = movieDAO.getById(id);
            System.out.print("ID: " + movie.getId());
            System.out.print(" | Title: " + movie.getTitle());
            System.out.print(" | Genre: " + movie.getGenre());
            System.out.print(" | Duration: " + movie.getDuration());
            System.out.print(" | Poster: " + movie.getPoster());
            System.out.println(" | Synopsis: " + movie.getSynopsis());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}