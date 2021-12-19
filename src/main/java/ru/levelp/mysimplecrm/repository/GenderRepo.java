package ru.levelp.mysimplecrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.levelp.mysimplecrm.model.Gender;

public interface GenderRepo extends JpaRepository<Gender, Long> {
}
