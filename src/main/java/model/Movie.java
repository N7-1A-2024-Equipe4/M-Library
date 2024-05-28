package model;

import java.awt.Image;

public class Movie {
    private String id;
    private String title;
    private MovieGenre genre;
    private int duration;
    private Image poster;
    private String synopsis;

    public Movie(String title, String genre, int year) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.poster = poster;
        this.synopsis = synopsis;
    }

    public int getId() {
        return id;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MovieGenre getGenre() {
        return genre;
    }

    public void setGenre(MovieGenre genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Image getPoster() {
        return poster;
    }

    public void setPoster(Image poster) {
        this.poster = poster;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
}