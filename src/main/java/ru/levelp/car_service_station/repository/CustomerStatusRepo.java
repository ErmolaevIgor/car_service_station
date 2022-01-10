package ru.levelp.car_service_station.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.levelp.car_service_station.model.CustomerStatus;

public interface CustomerStatusRepo extends JpaRepository<CustomerStatus, Long> {
}
