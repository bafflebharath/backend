package ecom.controller;

import ecom.dto.ERole;
import ecom.dto.User;
import ecom.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
@Api(tags = "User Controller")
public class UserController {

    private final UserService userService;

    // Constructor injection
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/details")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @ApiOperation("Get user content based on role")
    public String userAccess() {
        return "User Content.";
    }

    @GetMapping("/hello")
    @ApiOperation("Get a hello message")
    public String hello() {
        return "Hello, Swagger!";
    }

    @GetMapping("/moderator")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation("Get list of moderators")
    public List<User> getModerators() {
        return userService.findUsersByRole(ERole.ROLE_MODERATOR);
    }

    @GetMapping()
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    @ApiOperation("Get list of regular users")
    public List<User> getUsers() {
        return userService.findUsersByRole(ERole.ROLE_USER);
    }

}
