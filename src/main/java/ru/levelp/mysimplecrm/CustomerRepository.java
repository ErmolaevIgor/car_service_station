package ru.levelp.mysimplecrm;

import org.springframework.data.repository.CrudRepository;
import ru.levelp.mysimplecrm.entity.Customers;

public interface CustomerRepository extends CrudRepository<Customers, Integer> {
}
