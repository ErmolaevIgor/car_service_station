package ru.levelp.mysimplecrm.repository;

import org.springframework.data.repository.CrudRepository;
import ru.levelp.mysimplecrm.model.CustomerCars;

public interface CustomerCarsRepo extends CrudRepository <CustomerCars, Long> {
}
