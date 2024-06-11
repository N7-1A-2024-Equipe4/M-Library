package controller;

import dao.LibraryService;
import model.Library;
import session.Session;
import view.CreateLibraryView;
import view.ViewEnum;


import javax.swing.*;
import java.util.Date;

public class CreateLibraryController {
    private  final CreateLibraryView view;

    public CreateLibraryController(CreateLibraryView view) {this.view = view; }

    public void importPosterAction() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        ImageIcon image = new ImageIcon(fileChooser.getSelectedFile().getAbsolutePath());
        view.setPoster(image);        
    }


    public void createListAction(String libraryName, ImageIcon poster, String description) {
        LibraryService libraryService = new LibraryService();
        Library library = new Library(libraryName, poster, new Date(), Session.getUser(), description); 
        libraryService.addLibrary(library);

        MainController.getInstance().show(ViewEnum.LISTS, 1);
    }

    public void cancelAction() {
        MainController.getInstance().show(ViewEnum.LISTS, 1);
    }
}
