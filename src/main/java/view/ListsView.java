package view;

import controller.ListsController;

import javax.swing.*;

public class ListsView implements View {
    private final ListsController controller;
    private JPanel panel;
    private JButton createLibraryJButton;

    public ListsView() {
        this.controller = new ListsController(this);

        createLibraryJButton.addActionListener(actionEvent -> controller.
                goToLibraryCreationAction());
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public void refresh(Integer movieID) {

    }

}
