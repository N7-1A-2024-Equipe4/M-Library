package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Date createdAt;
    private ImageIcon picture;

    // Copy constructor
    public User(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.createdAt = new Date();
        this.picture = user.getPicture();
    }

    public User(int id) {
        this.id = id;
    }
}
