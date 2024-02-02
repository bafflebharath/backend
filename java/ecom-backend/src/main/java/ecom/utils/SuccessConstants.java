package ecom.utils;

public class SuccessConstants {

    public static final String USER_REGISTER_SUCCESS = "User registered successfully!";
    public static final String USER_SIGNOUT_SUCCESS = "Logout successfully!";

    private SuccessConstants() {
        // Private constructor to hide the implicit public one
        throw new AssertionError("SuccessConstants class should not be instantiated.");
    }
}
