package session;

import model.User;

public class Session {
    private static Session instance;

    private User user;

    private Session() {
    }

    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    public User getUser() {
        return user;
    }

    public void login(User user) {
        this.user = user;
    }

    public void logout() {
        this.user = null;
    }

    public boolean isSignedOut() {
        return user == null;
    }
}
