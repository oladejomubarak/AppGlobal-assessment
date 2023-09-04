package oladejo.mubarak.User.data.repository;

import oladejo.mubarak.User.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepo extends MongoRepository<User, String > {
    boolean existsByEmailIgnoreCase(String email);
    boolean existsByPhoneNumber(String phoneNumber);
    Optional <User> findUserByEmailIgnoreCase(String email);
    Optional <User> findUserByPhoneNumber(String phoneNumber);
}
