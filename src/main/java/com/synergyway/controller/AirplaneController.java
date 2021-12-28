package com.synergyway.controller;


import com.synergyway.entity.Airplane;
import com.synergyway.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/airplane")
public class AirplaneController {

    @Autowired
    private AirplaneService airplaneService;


    @GetMapping(path="/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Airplane> findAllCompanies()
    {
        return  airplaneService.getAllAirplanes();

    }

}
