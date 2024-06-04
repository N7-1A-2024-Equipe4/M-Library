package model;

import lombok.Getter;

import java.util.List;

import javax.swing.ImageIcon;

public class Library {

    private int id;
    @Getter
    private String name;
    private List<ElementOfLibrary> elements;
    private User owner;
    private String description;
    private ImageIcon icon;

    public Library(String name, List<ElementOfLibrary> elements, User owner) {
        this.name = name;
        this.elements = elements;
        this.owner = owner;
    }

    public Library(int id, String name, User owner, String description, ImageIcon icon) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.description = description;
        this.icon = icon;
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

    public int getId() {
        return id;
    }

    public void setMovies(List<Movie> movies) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setMovies'");
    }

}