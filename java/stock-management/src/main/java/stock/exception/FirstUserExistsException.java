package stock.exception;

public class FirstUserExistsException extends RuntimeException {

    public FirstUserExistsException(String message) {
        super(message);
    }
}
