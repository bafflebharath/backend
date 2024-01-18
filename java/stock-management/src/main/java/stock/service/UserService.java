package stock.service;

import org.springframework.http.ResponseEntity;
import stock.dto.User;

public interface UserService {
    ResponseEntity<String> registerUser(User request);
}
