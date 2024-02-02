package ecom.utils;

public class ErrorConstants {
    public static final String ROLE_NOT_FOUND = "Error: Role is not found.";
    public static final String USERNAME_EMAIL_EXISTS_ALREADY = "Error: Username or Email is already taken!";
    public static final String USER_NOT_FOUND = "User Not Found with username: ";
    public static final String UNAUTHORIZED_USER = "Error: Unauthorized";
    public static final String INTERNAL_SERVER_ERROR = "Error: Internal Server Error";

    // Private constructor to prevent instantiation
    private ErrorConstants() {
        // Private constructor to hide the implicit public one
        throw new AssertionError("ErrorConstants class should not be instantiated.");
    }
}
