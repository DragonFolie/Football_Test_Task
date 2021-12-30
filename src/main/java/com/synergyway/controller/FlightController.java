package com.synergyway.controller;


import com.synergyway.service.FlightService;
import com.synergyway.entity.Flight;
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

    @GetMapping(path="/allCompletedFlight")
    @ResponseStatus(HttpStatus.OK)
    public List<Flight> allCompletedFlight() throws ParseException {

        return flightService.getAllFlightWithCompletedStatus();
    }


    @PostMapping(path="/addNewFlight/{companyName}/{factorySerialNumberOfPlane}")
    @ResponseStatus(HttpStatus.OK)
    public Flight allActiveFlight(@PathVariable("companyName")String companyName , @PathVariable("factorySerialNumberOfPlane") int factorySerialNumberOfPlane
            ,@RequestBody Flight flight ) throws ParseException {

        flightService.addFlightToCompany(factorySerialNumberOfPlane,companyName, flight.getDistance(),flight.getDepartureCountry()
        ,flight.getDestinationCountry(),flight.getCreatedAt(),flight.getEndedAt(),flight.getEstimatedFlightTime(),flight.getDelayStartedAt());

        return flight;
    }



    @PutMapping(path="/updateFlightStatusToCompleted/{flightId}")
    @ResponseStatus(HttpStatus.OK)
    public String updateFlightStatusToCompleted (@PathVariable("flightId") int flightId ) throws ParseException {

        flightService.updateFlightStatusToCompleted(flightId);
        return "Updated to Completed :)";

    }


    @PutMapping(path="/updateFlightStatusToDelay/{flightId}/{newTimeDelayOfFlightInDateTime}")
    @ResponseStatus(HttpStatus.OK)
    public String updateFlightStatusToDelay (@PathVariable("flightId") int flightId, @PathVariable("newTimeDelayOfFlightInDateTime") String newTimeDelayOfFlightInDateTime )throws ParseException {

        flightService.updateStatusToDelay(flightId,newTimeDelayOfFlightInDateTime);
        return "Updated to Delay :)";

    }


    @PutMapping(path="/updateFlightStatusToActive/{flightId}/{newTimeStartOfFlightInDateTime}")
    @ResponseStatus(HttpStatus.OK)
    public String updateFlightStatusToActive (@PathVariable("flightId" ) int flightId , @PathVariable("newTimeStartOfFlightInDateTime") String newTimeStartOfFlightInDateTime)
            throws ParseException {

        flightService.updateFlightStatusToActive(flightId,newTimeStartOfFlightInDateTime);
        return "Updated to Active :)";

    }





}
