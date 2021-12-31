package com.synergyway.controller;

import com.synergyway.entity.AirCompany;
import com.synergyway.repository.AirCompanyRepository;
import com.synergyway.service.AirCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/airCompany")
public class AirCompanyController {

    @Autowired
    private AirCompanyService airCompanyService;


    @GetMapping(path="/all")
    @ResponseStatus(HttpStatus.OK)
    public List<AirCompany> findAllCompanies()
    {
        return  airCompanyService.findAll();

    }


    @PostMapping(path="/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Object addCompany(@RequestBody AirCompany airCompany)
    {


        return  airCompanyService.addCompany(airCompany);

    }


    @DeleteMapping(path="/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteCompany(@PathVariable("id") Long id)
    {
          airCompanyService.deleteCompany(id);
//          return ResponseEntity.ok().build() ;

        return "Ok,deleted :)";


    }


    @PutMapping(path="/update")
    @ResponseStatus(HttpStatus.OK)
    public String updateNameCompany(@RequestBody AirCompany airCompany)
    {
        airCompanyService.updateNameCompany(airCompany);

        return "Ok now you have updated company  :)";


    }


}
