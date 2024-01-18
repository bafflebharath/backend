package stock.dto;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Set;

@Setter
@Getter
@Document
public class User {
    @Getter
    private @MongoId ObjectId id;
    private String username;
    @Setter
    private String password;
    @Setter
        private Set<UserRole> userRoles;
}
