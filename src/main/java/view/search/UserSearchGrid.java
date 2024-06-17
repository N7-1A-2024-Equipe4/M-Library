package view.search;

import model.User;
import view.thumbnail.UserThumbnail;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class UserSearchGrid extends JPanel {
    public UserSearchGrid() {
        setLayout(new GridLayout(0, 5, 5, 5));
    }

    public void setUsers(List<User> users) {
        removeAll();

        for (User user : users) {
            UserThumbnail thumbnail = new UserThumbnail(user, 100, 100);
            this.add(thumbnail);
        }
    }
}
