package ru.levelp.car_service_station.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.levelp.car_service_station.model.Gender;

public interface GenderRepo extends JpaRepository<Gender, Long> {
}
