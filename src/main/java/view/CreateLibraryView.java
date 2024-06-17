package view;

import controller.CreateLibraryController;

import javax.swing.*;
import java.awt.*;


public class CreateLibraryView implements View{

    private final CreateLibraryController controller;

    private ImageIcon poster;

    private JPanel mainJPanel;
    private JButton importPosterJButton;
    private JTextArea descriptionJTextArea;
    private JButton createListJButton;
    private JButton cancelJButton;
    private JTextField libraryNameTextField;
    private JLabel libraryNameJLabel;
    private JPanel libraryNameJPanel;
    private JPanel importPosterJPanel;
    private JLabel importPosterJLabel;
    private JPanel descriptionJPanel;
    private JLabel descriptionJLabel;
    private JPanel wrapperJPanel;
    private JLabel posterPreviewJLabel;

    public CreateLibraryView() {
        controller = new CreateLibraryController(this);

        importPosterJButton.addActionListener(actionEvent -> controller
                .importPosterAction());

        createListJButton.addActionListener(actionEvent -> controller
                .createListAction(
                        libraryNameTextField.getText(),
                        poster,
                        descriptionJTextArea.getText()
                ));

        cancelJButton.addActionListener(actionEvent -> controller
                .cancelAction());
    }

    @Override
    public JPanel getPanel() {
        return mainJPanel;
    }

    @Override
    public void refresh(Integer modelId) {
        libraryNameTextField.setText("");
        poster = new ImageIcon();
        descriptionJTextArea.setText("");
        posterPreviewJLabel.setIcon(null);
    }

    public void setPoster(ImageIcon poster) {
        this.poster = poster;
        Image image = poster.getImage();
        Image newimg = image.getScaledInstance(posterPreviewJLabel.getWidth(), posterPreviewJLabel.getHeight(),  java.awt.Image.SCALE_SMOOTH);
        poster = new ImageIcon(newimg);
        posterPreviewJLabel.setIcon(poster);

    }
}
