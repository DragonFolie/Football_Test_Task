package com.synergyway.entity;


import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "flight")
@Getter
@ToString
@RequiredArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "flight_status")
    private String   flightStatus;

    @Column(name = "departure_country")
    private String   departureCountry;

    @Column(name = "destination_country")
    private String   destinationCountry;

    @Column(name = "distance")
    private String   distance;

    @Column(name = "estimated_flight_time")
    private String   estimatedFlightTime;

    @Column(name = "ended_at")
    private String   endedAt;

    @Column(name = "delay_started_at")
    private String   delayStartedAt;

    @Column(name = "created_at")
    private String   createdAt;




    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "air_Company_id")
    private AirCompany airCompany;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "airplane_id")
    private Airplane airplane;


    public Flight(String flightStatus, String departureCountry, String destinationCountry, String distance, String estimatedFlightTime, String endedAt, String delayStartedAt, String createdAt) {
        this.flightStatus = flightStatus;
        this.departureCountry = departureCountry;
        this.destinationCountry = destinationCountry;
        this.distance = distance;
        this.estimatedFlightTime = estimatedFlightTime;
        this.endedAt = endedAt;
        this.delayStartedAt = delayStartedAt;
        this.createdAt = createdAt;
    }
}
