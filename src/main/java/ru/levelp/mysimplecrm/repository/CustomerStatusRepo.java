package ru.levelp.mysimplecrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.levelp.mysimplecrm.model.CustomerStatus;

public interface CustomerStatusRepo extends JpaRepository<CustomerStatus, Long> {
}
