package com.synergyway.service;


import com.synergyway.entity.Airplane;
import com.synergyway.repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirplaneService {

    private AirplaneRepository airplaneRepository;


    @Autowired
    public void setAirplaneRepository(AirplaneRepository airplaneRepository) {
        this.airplaneRepository = airplaneRepository;
    }

    public List<Airplane> getAllAirplanes(){

        return airplaneRepository.findAll();

    }
}
