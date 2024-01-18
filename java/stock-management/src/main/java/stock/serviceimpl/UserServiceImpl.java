package stock.service_Impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import stock.dto.User;
import stock.exception.FirstUserExistsException;
import stock.repository.UserRepository;
import stock.service.UserService;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(User request) {
        if (userRepository.findByUsername(request.getUsername())!=null)
            throw new FirstUserExistsException("First user already exists.");

        // Create a new user
        User user = new User();
        user.setUsername(request.getUsername()); // You can set the username as needed
        user.setPassword(passwordEncoder.encode(request.getPassword())); // Encrypt the password
        user.setUserRoles(request.getUserRoles()); // You can set the roles as needed

        // Save the user to the database
        userRepository.save(user);
    }
}
