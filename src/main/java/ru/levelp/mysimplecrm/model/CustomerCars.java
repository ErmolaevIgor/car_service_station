package ru.levelp.mysimplecrm.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "customer_cars")
public class CustomerCars {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vin_number")
    private String vinNumber;

    @Column(name = "registration_number")
    private String registrationNumber;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "engine_modification")
    private String engineModification;

    @Column(name = "year_of_issue")
    private String yearOfIssue;

    @Column(name = "mileage")
    private String mileage;

}
