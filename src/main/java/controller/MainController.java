package controller;

import session.Session;
import view.*;
import view.home.HomeView;
import view.libraries.LibrariesView;

import java.util.Map;

public class MainController {
    private final MainView mainView;

    private final Map<ViewEnum, View> views;

    private static MainController instance;

    private MainController(MainView mainView) {
        this.mainView = mainView;
        views = Map.of(
                ViewEnum.LOGIN, new LoginView(),
                ViewEnum.HOME, new HomeView(),
                ViewEnum.MOVIE, new MovieView(),
                ViewEnum.PROFILE, new ProfileView(),
                ViewEnum.CREATELIBRARY, new CreateLibraryView(),
                ViewEnum.LISTS, new LibrariesView(),
                ViewEnum.LIST, new LibraryView()
        );
    }

    public static MainController getInstance() {
        if (instance == null) {
            throw new IllegalStateException("MainController not initialized");
        }
        return instance;
    }

    public static MainController initInstance(MainView view) {
        if (instance != null) {
            throw new IllegalStateException("MainController already initialized");
        }
        return instance = new MainController(view);
    }

    public void show(ViewEnum viewEnum, Integer modelID) {
        if (Session.isSignedOut() && viewEnum.isProtected()) {
            this.mainView.setContent(ViewEnum.LOGIN);
        } else {
            this.views.get(viewEnum).refresh(modelID);
            this.mainView.setContent(viewEnum);
        }
    }

    public View getView(ViewEnum viewEnum) {
        return views.get(viewEnum);
    }

    public void updateNavbar() {
        mainView.refresh(null);
    }
}
