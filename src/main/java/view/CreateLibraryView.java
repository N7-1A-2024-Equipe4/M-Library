package view;

import controller.CreateLibraryController;
import lombok.Setter;

import javax.swing.*;


public class CreateLibraryView implements View{

    private final CreateLibraryController controller;

    @Setter
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
    public void refresh(Integer modelID) {
        libraryNameTextField.setText("");
        poster = new ImageIcon();
        descriptionJTextArea.setText("");
    }
}
