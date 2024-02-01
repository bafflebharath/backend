package stock.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stock.dto.User;
import stock.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RolesAllowed({ "ROLE_ADMIN" })
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User request) {
        return userService.registerUser(request);
    }

    @PostMapping("/login")
    public User getUserDetailsAfterLogin(Authentication authentication) {
        return userService.getUserByUsername(authentication.getName());
    }
}
