package view.movie;

import model.Review;

import javax.swing.*;
import java.awt.*;

public class ReviewView extends JPanel {
    private JLabel userNameLabel;
    private JLabel ratingLabel;
    private JTextArea reviewTextArea;

    public ReviewView(Review review) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));

        // User Name
        userNameLabel = new JLabel(review.getAuthor().getUsername());
        userNameLabel.setFont(new Font("Liberation Sans", Font.BOLD, 16));

        userNameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Rating
        ratingLabel = new JLabel("Note: " + review.getRating());
        ratingLabel.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
        ratingLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Review Text
        reviewTextArea = new JTextArea(review.getReview());
        reviewTextArea.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
        reviewTextArea.setLineWrap(true);
        reviewTextArea.setWrapStyleWord(true);
        reviewTextArea.setEditable(false);
        reviewTextArea.setAlignmentX(Component.LEFT_ALIGNMENT);
        reviewTextArea.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

        // Adding components
        add(userNameLabel);
        add(ratingLabel);
        add(Box.createVerticalStrut(5));
        add(reviewTextArea);
        add(Box.createVerticalStrut(5));
        add(new JSeparator(SwingConstants.HORIZONTAL));
    }
}
