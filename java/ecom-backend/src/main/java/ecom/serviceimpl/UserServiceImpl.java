package ecom.serviceimpl;

import ecom.dto.ERole;
import ecom.dto.Role;
import ecom.dto.User;
import ecom.repository.RoleRepository;
import ecom.repository.UserRepository;
import ecom.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    // Constructor injection
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<User> findUsersByRole(ERole roleEnum) {
        Optional<Role> role = roleRepository.findByName(roleEnum);
        return role.map(userRepository::findByRolesContaining).orElseThrow(() ->
                new RuntimeException("Error: Role is not found."));
    }
}
