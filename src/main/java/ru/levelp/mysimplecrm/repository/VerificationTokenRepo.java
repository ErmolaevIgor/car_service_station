package ru.levelp.mysimplecrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.levelp.mysimplecrm.service.VerificationToken;

public interface VerificationTokenRepo extends JpaRepository<VerificationToken, Long> {

    VerificationToken findByToken(String token);

}
