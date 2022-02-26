package com.simbirsoft.cars.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Car {

    @Id
    @SequenceGenerator(name = "carIdSeq", sequenceName = "car_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carIdSeq")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "manufacturer", columnDefinition = "varchar(500)", nullable = false)
    private String manufacturer;

    @Column(name = "model", columnDefinition = "varchar(500)", nullable = false)
    private String model;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}