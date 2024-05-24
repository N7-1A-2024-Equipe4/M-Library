package view;

import controller.ListsController;

import javax.swing.*;

public class ListsView extends View {
    private final ListsController controller;
    private JPanel panel;

    public ListsView() {
        this.controller = new ListsController();
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public void update() {

    }
}
