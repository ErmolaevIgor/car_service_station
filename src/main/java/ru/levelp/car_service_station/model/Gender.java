package ru.levelp.car_service_station.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "genders")
public class Gender {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

}
