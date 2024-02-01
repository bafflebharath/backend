package ecom.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<String> handleFirstUserExistsException(FirstUserExistsException exception) {
        return ResponseEntity.badRequest().body("User already exists");
    }

    @ExceptionHandler
    public ResponseEntity<String> handleUserNotExistsException(UserNotExistsException exception){
        return ResponseEntity.badRequest().body("User not exists");
    }

    @ExceptionHandler
    public ResponseEntity<String> handleRoleNotExistsException(RoleNotExistsException exception){
        return ResponseEntity.badRequest().body("User not exists");
    }
}
