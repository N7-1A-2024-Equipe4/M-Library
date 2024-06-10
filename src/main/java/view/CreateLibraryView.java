package view;

import controller.CreateLibraryController;

import javax.swing.*;


public class CreateLibraryView {

    private final CreateLibraryController controller;

    private ImageIcon poster;

    private JPanel panel1;
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

    public CreateLibraryView() {
        controller = new CreateLibraryController(this);

        importPosterJButton.addActionListener(actionEvent -> controller
                .importPosterAction());

        createListJButton.addActionListener(actionEvent -> controller
                .createListAction(
                        libraryNameTextField.getText(),
                        poster.getImage(),
                        descriptionJTextArea.getText()
                ));

        cancelJButton.addActionListener(actionEvent -> controller
                .cancelAction());

    }

    public void setPoster(ImageIcon poster) {
        this.poster = poster;
    }


}
