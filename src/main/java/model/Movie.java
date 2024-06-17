package model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
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

    public Movie(String title, MovieGenre genre, int duration, String synopsis, float rating) {
        this(-1, title, genre, duration, null, synopsis, rating);
    }
}
