package ecom.service;

import ecom.dto.ERole;
import ecom.dto.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public List<User> findUsersByRole(ERole role);
}
