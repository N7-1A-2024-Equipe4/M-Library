package view;

import model.Library;
import model.Movie;
import view.home.MovieThumbnail;
import java.util.List;

import javax.swing.*;
import java.awt.*;

public class ListsGrid extends JPanel {

    public ListsGrid() {
        setLayout(new GridLayout(0,5,5,5));
    }

    private void setLists(List<Library> libraries){
        removeAll();

        for (Library lib : libraries) {
            //MovieThumbnail thumbnail = new MovieThumbnail(movie);
            //this.add(thumbnail);
        }
    }


}
