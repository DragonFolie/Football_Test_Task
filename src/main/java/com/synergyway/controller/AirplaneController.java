package com.synergyway.controller;


import com.synergyway.classAssistants.NamesContainer;
import com.synergyway.entity.Airplane;
import com.synergyway.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/airplane")
public class AirplaneController {

    @Autowired
    private AirplaneService airplaneService;


    @GetMapping(path = "/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Airplane> findAllCompanies() {
        return airplaneService.getAllAirplanes();

    }

    @PostMapping(path = "/add/{CompanyName}")
    @ResponseStatus(HttpStatus.CREATED)
    public Airplane addAirplaneToCompany(@PathVariable("CompanyName") String name, @RequestBody Airplane airplane) {

        airplaneService.addAirplaneToCompany(name, airplane);

        return airplane;
    }


    @PutMapping(path = "/updateAirCompanyForAllPlanes/{oldName}/{newName}")
    @ResponseStatus(HttpStatus.OK)
    public String updateAirCompanyForAirplaneByPathVariable(@PathVariable("oldName") String oldName, @PathVariable("newName") String newName) {

        airplaneService.updateAirCompanyForAirplanes(oldName, newName);

        return "Nice";
    }


    @PutMapping(path = "/updateAirCompanyForSinglePlane")
    @ResponseStatus(HttpStatus.OK)
    public Airplane updateAirCompanyForSingleAirplane(@RequestBody Airplane airplane) {

        airplaneService.updateAirCompanyForSingleAirplane(airplane);

        return airplane;

    }

}
