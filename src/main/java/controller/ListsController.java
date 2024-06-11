package controller;

import view.ListsView;
import view.ViewEnum;

public class ListsController {

    private final ListsView view;

    public ListsController(ListsView view) {
        this.view = view;
    }


    public void goToLibraryCreationAction() {
        MainController.getInstance().show(ViewEnum.CREATELIBRARY, 1);
    }
}
