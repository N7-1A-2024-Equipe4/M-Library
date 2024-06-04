package view.libraries;

import model.Library;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ListsGrid extends JPanel {

    public ListsGrid() {
        setLayout(new GridLayout(0,5,5,5));
    }

    public void setLists(List<Library> libraries){
        removeAll();
        for (Library lib : libraries) {
            ListsThumbnail thumbnail = new ListsThumbnail(lib);
            this.add(thumbnail);
        }
    }
}
