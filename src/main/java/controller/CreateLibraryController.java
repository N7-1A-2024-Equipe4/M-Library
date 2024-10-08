package controller;

import model.Library;
import service.LibraryService;
import service.SessionService;
import view.CreateLibraryView;
import view.ViewEnum;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.Date;

public class CreateLibraryController {
    private final CreateLibraryView view;

    public CreateLibraryController(CreateLibraryView view) {
        this.view = view;
    }

    public void importPosterAction() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", "jpg", "png");
        fileChooser.setFileFilter(filter);
        fileChooser.showOpenDialog(null);
        ImageIcon image = new ImageIcon(fileChooser.getSelectedFile().getAbsolutePath());
        view.setPoster(image);
    }


    public void createListAction(String libraryName, ImageIcon poster, String description) {
        LibraryService libraryService = new LibraryService();
        Library library = new Library(libraryName, poster, new Date(), SessionService.getUser(), description);
        System.err.println("Library: " + library);
        libraryService.addLibrary(library);
        MainController.getInstance().show(ViewEnum.LIBRARIES, null);
    }

    public void cancelAction() {
        MainController.getInstance().show(ViewEnum.LIBRARIES, null);
    }
}
