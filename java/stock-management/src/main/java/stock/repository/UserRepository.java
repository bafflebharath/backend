package stock.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import stock.dto.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    @Query("{username:'?0'}")
    User findByUsername(String username);
}
