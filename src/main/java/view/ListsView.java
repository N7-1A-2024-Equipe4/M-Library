package view;

import controller.ListsController;

import javax.swing.*;
import java.awt.*;

public class ListsView implements View {
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
    public void refresh(Integer movieID) {

    }

}
