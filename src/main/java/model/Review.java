package model;

public class Review {

    private int id;
    private String review;
    private int rating;
    private User author;
    private Movie movie;

    public Review(int id, String text, int rating, User user, Movie movie) {
        this.id = id;
        this.review = text;
        this.rating = rating;
        this.author = user;
        this.movie = movie;
    }

    public Review(String text, int rating, User user, Movie movie) {
        this.review = text;
        this.rating = rating;
        this.author = user;
        this.movie = movie;
    }

    public int getId() {
        return id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String text) {
        this.review = text;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User user) {
        this.author = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
