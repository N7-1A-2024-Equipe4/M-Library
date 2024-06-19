package view;

public enum ViewEnum {
    LOGIN(false),
    HOME(false),
    LIBRARIES(true),
    PROFILE(true),
    MOVIE(false),
    CREATELIBRARY(true),
    LIBRARY(true),
    SEARCH(false);

    private boolean isAuthRequired;

    ViewEnum(boolean isAuthRequired) {
        this.isAuthRequired = isAuthRequired;
    }

    public boolean isAuthRequired() {
        return this.isAuthRequired;
    }
}
