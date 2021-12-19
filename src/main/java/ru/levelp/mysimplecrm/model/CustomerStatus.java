package ru.levelp.mysimplecrm.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "customer_statuses")
public class CustomerStatus {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    public CustomerStatus() {
        super();
    }

}
