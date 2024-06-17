package view.libraries;

import model.Library;
import view.thumbnail.LibrariesThumbnail;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class LibrariesGrid extends JPanel {

    public LibrariesGrid() {
        setLayout(new GridLayout(0,5,5,5));
    }

    public void setLists(List<Library> libraries){
        removeAll();
        for (Library lib : libraries) {
            LibrariesThumbnail thumbnail = new LibrariesThumbnail(lib);
            this.add(thumbnail);
        }
    }
}
