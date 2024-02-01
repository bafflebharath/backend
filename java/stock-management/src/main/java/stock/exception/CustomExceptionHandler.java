package stock.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler
    public ResponseEntity handleFirstUserExistsException(FirstUserExistsException exception){
        return ResponseEntity.badRequest().body("User already exists");
    }

    @ExceptionHandler
    public ResponseEntity handleUserNotExistsException(UserNotExistsException exception){
        return ResponseEntity.badRequest().body("User not exists");
    }
}
