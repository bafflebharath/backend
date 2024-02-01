package stock.serviceimpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import stock.dto.User;
import stock.exception.FirstUserExistsException;
import stock.exception.UserNotExistsException;
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
            if(checkUserExists(request.getUsername())) {
                throw new FirstUserExistsException("User already exists.");
            }else{
                User user = new User();
                user.setUsername(request.getUsername());
                user.setEmailId(request.getEmailId());
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
            }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ex.getMessage());
        }
    }

    @Override
    public User getUserByUsername(String username) {
        try {
            if (checkUserExists(username)) {
                return userRepository.findByUsername(username);
            } else {
                throw new UserNotExistsException("User not exists.");
            }
        } catch (Exception ex) {
            // Log the exception or handle it appropriately
            return handleException(ex);
        }
    }

    private boolean checkUserExists(String username) {
        return userRepository.findByUsername(username) != null;
    }

    private User handleException(Exception ex) {
        // Log the exception or handle it appropriately
        // For simplicity, just return a default User or null
        return new User(); // You might want to return null or throw a different exception based on your requirements
    }
}
