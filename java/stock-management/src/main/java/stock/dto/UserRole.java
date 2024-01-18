package stock.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Setter
@Getter
public class UserRole implements GrantedAuthority {
    private transient Role role;

    @Override
    public String getAuthority() {
        return role.getName();
    }

}
