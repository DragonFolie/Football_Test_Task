package com.synergyway.entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "airplane")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Airplane {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "factory_serial_number")
    private int factorySerialNumber;

    @Column(name = "number_of_flight")
    private String numberOfFlight;

    @Column(name = "flight_distance")
    private int flightDistance;

    @Column(name = "fuel_capacity")
    private int fuelCapacity;

    @Column(name = "type")
    private String type;

    @Column(name = "created_at")
    private String createdAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "air_company_id")
    private AirCompany airCompany;


    public Airplane(String name, int factorySerialNumber, String numberOfFlight, int flightDistance, int fuelCapacity, String type, String createdAt) {
        this.name = name;
        this.factorySerialNumber = factorySerialNumber;
        this.numberOfFlight = numberOfFlight;
        this.flightDistance = flightDistance;
        this.fuelCapacity = fuelCapacity;
        this.type = type;
        this.createdAt = createdAt;
    }


}
