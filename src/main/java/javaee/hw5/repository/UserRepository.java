package javaee.hw5.repository;

import javaee.hw5.repository.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User save(User user);

    Optional<User> findById(User user);

    Optional<User> findByUsername(String username);

}
