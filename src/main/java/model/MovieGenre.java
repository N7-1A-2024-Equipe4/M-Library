package model;

public enum MovieGenre {

    ACTION("Action"),
    COMEDY("Comedy"),
    DRAMA("Drama"),
    HORROR("Horror"),
    ROMANCE("Romance"),
    SCI_FI("Sci-Fi"),
    DOCUMENTARY("Documentary"),
    THRILLER("Thriller"),
    FANTASY("Fantasy");

    private final String displayName;

    MovieGenre(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
    
    public static MovieGenre fromDisplayName(String displayName) {
        for (MovieGenre genre : MovieGenre.values()) {
            if (genre.getDisplayName().equals(displayName)) {
                return genre;
            }
        }
        throw new IllegalArgumentException("No enum constant " + MovieGenre.class.getCanonicalName() + " with displayName " + displayName);
    }
}