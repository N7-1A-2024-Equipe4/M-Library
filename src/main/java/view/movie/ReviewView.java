package view.movie;

import model.Review;

import javax.swing.*;
import java.awt.*;

public class ReviewView extends JPanel {
    private JLabel userNameLabel;
    private JLabel ratingLabel;
    private JLabel reviewText;

    public ReviewView(Review review) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));

        userNameLabel = new JLabel(review.getAuthor().getUsername());
        userNameLabel.setFont(new Font("Liberation Sans", Font.BOLD, 16));
        userNameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        ratingLabel = new JLabel("Note: " + review.getRating());
        ratingLabel.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
        ratingLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        reviewText = new JLabel(review.getReview());
        reviewText.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
        reviewText.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

        // Adding components
        add(userNameLabel);
        add(ratingLabel);
        add(reviewText);
    }
}
