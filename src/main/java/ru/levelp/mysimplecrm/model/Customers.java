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

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    public Customers() {
        super();
    }

}
