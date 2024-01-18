package stock.serviceimpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import stock.dto.User;
import stock.exception.FirstUserExistsException;
import stock.repository.UserRepository;
import stock.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ResponseEntity<String> registerUser(User request) {
        try {
            validateUserNotExists(request.getUsername());

            User user = new User();
            user.setUsername(request.getUsername());
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            user.setUserRoles(request.getUserRoles());

            User registeredUser = userRepository.save(user);

            if (registeredUser.getId() != null) {
                return ResponseEntity.status(HttpStatus.CREATED)
                        .body("User successfully registered");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Failed to register user");
            }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ex.getMessage());
        }
    }

    private void validateUserNotExists(String username) {
        if (userRepository.findByUsername(username) != null) {
            throw new FirstUserExistsException("First user already exists.");
        }
    }
}
