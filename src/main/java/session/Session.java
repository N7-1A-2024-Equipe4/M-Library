package session;

import dao.UserDAO;

public class Session {
    private static String name;

    private Session() {
    }

    public static String getUsername() {
        if (isSignedOut()) {
            return "Not logged in";
        }
        return name;
    }

    public static boolean login(String username) {
        name = UserDAO.getUserByUsername(username) != null ? username : null;
        return !isSignedOut();
    }

    public static void logout() {
        name = null;
    }

    public static boolean isSignedOut() {
        return name == null;
    }

}
