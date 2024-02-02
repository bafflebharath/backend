package ecom.service;

import ecom.payload.request.LoginRequest;
import ecom.payload.request.SignupRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public interface AuthService {

    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest);
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest);
    public ResponseEntity<?> logoutUser();
}
