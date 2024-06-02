package model;

import javax.swing.*;
import java.awt.*;

public class Movie {
    private int id;
    private String title;
    private MovieGenre genre;
    private int duration;
    private ImageIcon poster;
    private String synopsis;

    public Movie(String title, MovieGenre genre, int duration, ImageIcon poster, String synopsis) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.poster = poster;
        this.synopsis = synopsis;
    }

    public Movie(int id, String title, MovieGenre genre, int duration, ImageIcon poster, String synopsis) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.poster = poster;
        this.synopsis = synopsis;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
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

    public ImageIcon getPoster() {
        return poster;
    }

    public void setPoster(ImageIcon poster) {
        this.poster = poster;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
}