package view;

public enum ViewEnum {
    LOGIN(true),
    HOME(false),
    LISTS(true),
    PROFILE(true),
    MOVIE(false),
    CREATELIBRARY(true),
    LIST(true);

    private boolean isProtected;

    ViewEnum(boolean isProtected) {
        this.isProtected = isProtected;
    }

    public boolean isProtected() {
        return this.isProtected;
    }
}
