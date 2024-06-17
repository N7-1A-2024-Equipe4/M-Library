package view.thumbnail;

import lombok.Getter;
import model.User;
import utils.image.ImageUtil;

import javax.swing.*;
import java.awt.*;

public class UserThumbnail extends JComponent {

    @Getter
    private int userId;
    private JLabel usernameLabel;
    private JLabel pictureLabel;

    public UserThumbnail(User user) {
        this(user, 100, 100);
    }

    public UserThumbnail(User user, int width, int height) {

        this.userId = user.getId();
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(width, height));

        usernameLabel = new JLabel(user.getUsername(), SwingConstants.CENTER);
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 16));

        pictureLabel = new JLabel();
        pictureLabel.setHorizontalAlignment(SwingConstants.CENTER);

        if (user.getPicture() != null) {
            pictureLabel.setIcon(new ImageIcon(ImageUtil.getScaledImage(user.getPicture().getImage(), width, height)));
        }

        add(usernameLabel, BorderLayout.NORTH);
        add(pictureLabel, BorderLayout.CENTER);
    }
}
