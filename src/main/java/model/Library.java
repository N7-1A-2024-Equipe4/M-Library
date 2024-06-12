package model;

import lombok.Data;
import lombok.Getter;

import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.swing.ImageIcon;
@Data
public class Library {

    private int id;
    private String name;
    private Date date;
    private ImageIcon poster;
    private Date creationDate;
    private User owner;
    private String description;
    private ImageIcon icon;
    private List<ElementOfLibrary> elements;

    public Library(String name, ImageIcon poster, Date creationDate, User owner, String description) {
        this.name = name;
        this.poster = poster;
        this.creationDate = creationDate;
        this.owner = owner;
        this.description = description;
    }

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

    public Library() {}

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

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ImageIcon getPoster() {
        return poster;
    }

    public byte[] getPosterBytes() {
        BufferedImage image = new BufferedImage(poster.getIconWidth(), poster.getIconHeight(), BufferedImage.TYPE_INT_RGB);
        poster.paintIcon(null, image.getGraphics(), 0, 0);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "png", baos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return baos.toByteArray();
    }


    public void setPoster(ImageIcon poster) {
        this.poster = poster;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ElementOfLibrary> getElements() {
        return elements;
    }

    public void setElements(List<ElementOfLibrary> elements) {
        this.elements = elements;
    }

    public void setMovies(List<Movie> movies) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setMovies'");
    }

}