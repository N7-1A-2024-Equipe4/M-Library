
package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Movie {
    private int id;
    private String title;
    private MovieGenre genre;
    private int duration;
    private Image poster;
    private String synopsis;
    private List<Person> actors;
    private List<Person> directors;
    private List<Person> screenwriters;

    public Movie(String title, MovieGenre genre, int duration, Image poster, String synopsis) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.poster = poster;
        this.synopsis = synopsis;
        this.actors = new ArrayList<>();
        this.directors = new ArrayList<>();
        this.screenwriters = new ArrayList<>();
}

    public Movie(int id, String title, MovieGenre genre, int duration, Image poster, String synopsis) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.poster = poster;
        this.synopsis = synopsis;
        this.actors = new ArrayList<>();
        this.directors = new ArrayList<>();
        this.screenwriters = new ArrayList<>();
    }

    public Movie(String title, MovieGenre genre, int duration, String synopsis) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.synopsis = synopsis;
        this.actors = new ArrayList<>();
        this.directors = new ArrayList<>();
        this.screenwriters = new ArrayList<>();
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

    public List<Person> getActors() {
        return actors;
    }

    public void addActor(Person actor) {
        actors.add(actor);
    }

    public List<Person> getDirectors() {
        return directors;
    }

    public void addDirector(Person director) {
        directors.add(director);
    }

    public List<Person> getScreenwriters() {
        return screenwriters;
    }

    public void addScreenwriter(Person screenwriter) {
        screenwriters.add(screenwriter);
    }
}