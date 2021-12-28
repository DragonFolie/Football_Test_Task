package com.synergyway.service;


import com.synergyway.entity.Flight;
import com.synergyway.repository.FlightRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class FlightService {


    @Autowired
    private FlightRepository flightRepository;



    public List<Flight> findAllFlights(){

        return flightRepository.findAll();

    }


}
