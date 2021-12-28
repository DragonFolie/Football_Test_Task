package com.synergyway.controller;


import com.synergyway.entity.Flight;
import com.synergyway.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;


    @GetMapping(path="/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Flight> findallInfo(){

        return flightService.findAllFlights();
    }



}
