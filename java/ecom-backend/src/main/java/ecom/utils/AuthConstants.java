package ecom.utils;

public class AuthConstants {

    public static final String AUTHORIZATION = "Authorization";

    public static final String BEARER = "Bearer ";

    private AuthConstants() {
        // Private constructor to hide the implicit public one
        throw new AssertionError("SuccessConstants class should not be instantiated.");
    }
}
