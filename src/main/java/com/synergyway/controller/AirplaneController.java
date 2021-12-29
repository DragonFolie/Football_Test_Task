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


    @GetMapping(path="/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Airplane> findAllCompanies()
    {
        return  airplaneService.getAllAirplanes();

    }


    @PostMapping(path="/updateAirCompanyForAllPlane/{oldName}/{newName}")
    @ResponseStatus(HttpStatus.OK)
    public String updateAirCompanyForAirplaneByPathVariable(@PathVariable("oldName") String oldName,@PathVariable("newName") String newName){

        airplaneService.updateAirCompanyForAirplanes(oldName,newName);

        return "Nice";
    }





    @PostMapping(path="/updateAirCompanyForSinglePlane/{serialNumberOfPlane}/{newNameOfAirCompany}")
    @ResponseStatus(HttpStatus.OK)
    public String updateAirCompanyForSingleAirplane(@PathVariable("serialNumberOfPlane") int serialNumberOfPlane,@PathVariable("newNameOfAirCompany") String newNameOfAirCompany){

        airplaneService.updateAirCompanyForSingleAirplane(serialNumberOfPlane,newNameOfAirCompany);

        return "Nice";
    }


    @Deprecated
    @PostMapping(path="/updateAirCompanyForAllPlane")
    @ResponseStatus(HttpStatus.OK)
    public NamesContainer updateAirCompanyForAirplaneByRequestBody(@RequestBody NamesContainer namesContainer){

        namesContainer.setNewName(namesContainer.getNewName());
        namesContainer.setOldName(namesContainer.getOldName());

        return namesContainer;
    }

}
