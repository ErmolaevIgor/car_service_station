package ru.levelp.mysimplecrm.repository;

import org.springframework.data.repository.CrudRepository;
import ru.levelp.mysimplecrm.model.Users;

import java.util.Optional;

public interface UserRepo extends CrudRepository<Users, Long> {
    Optional<Users> findUserByEmail(String email);
}
