package model;

public class Review {

    private int id;
    private String review;
    private float rating;
    private User author;
    private Movie movie;

    public Review(int id, String text, float rating, User user, Movie movie) {
        this.id = id;
        this.review = text;
        this.rating = rating;
        this.author = user;
        this.movie = movie;
    }

    public Review(String text, float rating, User user, Movie movie) {
        this(-1, text, rating, user, movie);
    }

    public int getId() {
        return id;
    }

    public String getReview() {
        return review;
    }

    public float getRating() {
        return rating;
    }

    public User getAuthor() {
        return author;
    }

    public Movie getMovie() {
        return movie;
    }

}