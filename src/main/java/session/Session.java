package session;

import dao.UserDAO;
import lombok.Getter;
import model.User;

public class Session {
    private static final UserDAO userDAO = new UserDAO();
    @Getter
    private static User user;

    public static String getUsername() {
        if (isSignedOut()) {
            return "Not logged in";
        }
        return user.getUsername();
    }

    /**
     * Logs in the user if the username and password match.<br><br>
     * <p>
     * The user needs to be logged out to be able to log in.<br>
     * If the login was successful, the user is stored in the session.<br>
     *
     * @param username
     * @param password
     * @return true if the login was successful, false otherwise
     */
    public static boolean login(String username, String password) {
        if (!isSignedOut()) {
            return false;
        }
        try {
            User fetchedUser = userDAO.getUserByUsername(username);
            if (fetchedUser != null && isPasswordMatching(password, fetchedUser.getPassword())) {
                Session.user = fetchedUser;
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean isPasswordMatching(String password, String hashedPassword) {
        // TODO compare hashed passwords with salt (bcrypt?) instead of plain
        return password.equals(hashedPassword);
    }

    public static void logout() {
        user = null;
    }

    public static boolean isSignedOut() {
        return user == null;
    }

    public static String getPassword() {
        if (isSignedOut()) {
            return "Not logged in";
        }
        return user.getPassword();
    }

    public static boolean isLoggedIn() {
        return !isSignedOut();
    }
}
