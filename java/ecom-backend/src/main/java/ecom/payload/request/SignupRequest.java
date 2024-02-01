package ecom.payload.request;

import java.util.Set;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
public class SignupRequest {
    @Setter
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @Setter
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @Setter
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    private Set<String> roles;

    public void setRole(Set<String> roles) {
        this.roles = roles;
    }
}