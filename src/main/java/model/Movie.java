package model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Movie {
    private int id;
    private String title;
    private MovieGenre genre;
    private int duration;
    private ImageIcon poster;
    private String synopsis;
    private float rating;
    private List<Person> actors;
    private List<Person> directors;
    private List<Person> screenwriters;

    public Movie(int id, String title, MovieGenre genre, int duration, ImageIcon poster, String synopsis, float rating) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.poster = poster;
        this.synopsis = synopsis;
        this.rating = rating;
        this.actors = new ArrayList<>();
        this.directors = new ArrayList<>();
        this.screenwriters = new ArrayList<>();
    }

    public Movie(String title, MovieGenre genre, int duration, ImageIcon poster, String synopsis, float rating) {
        this(-1, title, genre, duration, poster, synopsis, rating);
    }

    public Movie(String title, MovieGenre genre, int duration, String synopsis, float rating) {
        this(-1, title, genre, duration, null, synopsis, rating);
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

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public List<Person> getActors() {
        return actors;
    }

    public void setActors(List<Person> actors) {
        this.actors = actors;
    }

    public List<Person> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Person> directors) {
        this.directors = directors;
    }

    public List<Person> getScreenwriters() {
        return screenwriters;
    }

    public void setScreenwriters(List<Person> screenwriters) {
        this.screenwriters = screenwriters;
    }

    public void addActor(Person actor) {
        actors.add(actor);
    }

    public void addDirector(Person director) {
        directors.add(director);
    }

    public void addScreenwriter(Person screenwriter) {
        screenwriters.add(screenwriter);
    }
}
