package ru.levelp.mysimplecrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.levelp.mysimplecrm.model.Users;

import java.util.Optional;

public interface UserRepo extends JpaRepository<Users, Long> {
    Users findByEmail(String email);
//    Optional<Users> findByEmail(String email);
}
