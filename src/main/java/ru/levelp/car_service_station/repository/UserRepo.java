package ru.levelp.car_service_station.repository;

import org.springframework.data.repository.CrudRepository;
import ru.levelp.car_service_station.model.Users;

import java.util.Optional;

public interface UserRepo extends CrudRepository<Users, Long> {
    Optional<Users> findUserByEmail(String email);
}
