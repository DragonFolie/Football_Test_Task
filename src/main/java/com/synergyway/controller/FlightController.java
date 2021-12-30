package com.synergyway.controller;


import com.synergyway.entity.Flight;
import com.synergyway.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;





    @GetMapping(path="/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Flight> findAllInfo(){

        return flightService.findAllFlights();
    }

    @GetMapping(path="/allActiveFlight/{companyName}")
    @ResponseStatus(HttpStatus.OK)
    public List<Flight> allActiveFlight(@PathVariable("companyName")String companyName ) throws ParseException {

        return flightService.allActiveFlightLessThan24Hour(companyName);
    }


    @PostMapping(path="/addNewFlight/{companyName}/{factorySerialNumberOfPlane}")
    @ResponseStatus(HttpStatus.OK)
    public Flight allActiveFlight(@PathVariable("companyName")String companyName , @PathVariable("factorySerialNumberOfPlane") int factorySerialNumberOfPlane
            ,@RequestBody Flight flight ) throws ParseException {

        flightService.addFlightToCompany(factorySerialNumberOfPlane,companyName, flight.getDistance(),flight.getDepartureCountry()
        ,flight.getDestinationCountry(),flight.getCreatedAt(),flight.getEndedAt(),flight.getEstimatedFlightTime(),flight.getDelayStartedAt());

        return flight;
    }





}
