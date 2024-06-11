package model;

import lombok.Data;
import lombok.Getter;

import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;

@Data
public class Library {
    private String name;
    private Date date;
    private List<ElementOfLibrary> elements;
    private User owner;
    private String description;
    private ImageIcon icon;
    private int id;

    public Library(String name, List<ElementOfLibrary> elements, User owner) {
        this.name = name;
        this.elements = elements;
        this.owner = owner;
    }

    public Library(int id, String name, User owner, String description, ImageIcon icon, Date date) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.description = description;
        this.icon = icon;
        this.date = date;
    }

    public void addElement(ElementOfLibrary element) {
        elements.add(element);
    }

    public void removeElement(ElementOfLibrary element) {
        elements.remove(element);
    }

    public void removeElement(int movie_id) {
        // TODO: implement this method
    }

    public void setMovies(List<Movie> movies) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setMovies'");
    }

}