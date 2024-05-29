package model;

import java.util.List;

public class Library {

    private String name;
    private List<ElementOfLibrary> elements;
    private User owner;

    public Library(String name, List<ElementOfLibrary> elements, User owner) {
        this.name = name;
        this.elements = elements;
        this.owner = owner;
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

}
