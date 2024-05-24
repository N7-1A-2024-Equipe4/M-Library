package controller;

import view.*;

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
                ViewEnum.LISTS, new ListsView()
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

    public void show(ViewEnum viewEnum) {
        this.views.get(viewEnum).update();
        this.mainView.setContent(viewEnum);
    }

    public View getView(ViewEnum viewEnum) {
        return views.get(viewEnum);
    }

    public void updateNavbar() {
        mainView.update();
    }
}
