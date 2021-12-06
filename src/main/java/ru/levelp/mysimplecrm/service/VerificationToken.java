package ru.levelp.mysimplecrm.service;

import lombok.Getter;
import lombok.Setter;
import ru.levelp.mysimplecrm.model.Users;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity(name = "verification_token")
public class VerificationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;

    @OneToOne(targetEntity = Users.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "id")
    private Users user;

    private Date expireDate;

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public VerificationToken() {

    }
}
