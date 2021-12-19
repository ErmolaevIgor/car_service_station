package ru.levelp.mysimplecrm.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customers_id_seq")
    @SequenceGenerator(name = "customers_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @ManyToOne
    @Getter @Setter
    private Gender gender;

    @ManyToOne
    private CustomerStatus status;

    public Customers() {
        super();
    }

}
