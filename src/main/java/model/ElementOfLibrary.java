package model;

public class ElementOfLibrary {

    private Movie movie;
    private String note;

    public ElementOfLibrary(Movie movie, String note) {
        this.movie = movie;
        this.note = note;
    }

    public ElementOfLibrary(Movie movie) {
        this.movie = movie;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
