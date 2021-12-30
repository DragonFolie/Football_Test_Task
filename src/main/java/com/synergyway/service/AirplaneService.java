package com.synergyway.service;


import com.synergyway.entity.AirCompany;
import com.synergyway.entity.Airplane;
import com.synergyway.repository.AirCompanyRepository;
import com.synergyway.repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirplaneService {

    private AirplaneRepository airplaneRepository;

    @Autowired
    public void setAirplaneRepository(AirplaneRepository airplaneRepository) {
        this.airplaneRepository = airplaneRepository;
    }


    public void addAirplaneToCompany(String companyName , String name, int factorySerialNumber , String numberOfFlight ,
                                     int flightDistance , int fuelCapacity ,String type , String createdAt ){

        int airCompanyId  = getAirCompanyByName(companyName);
        airplaneRepository.addAirplaneToCompany(name, factorySerialNumber, numberOfFlight, flightDistance, fuelCapacity, type, createdAt, airCompanyId);


    }



    public List<Airplane> getAllAirplanes(){

        return airplaneRepository.findAll();

    }


    public int getAirCompanyByName(String name) {

        return airplaneRepository.getAirCompanyByName(name);

    }


    public void updateAirCompanyForAirplanes(String oldName,String newName){

        int oldNameID = getAirCompanyByName(oldName);
        int newNameID = getAirCompanyByName(newName);

        airplaneRepository.updateAirCompanyForAirplane(newNameID,oldNameID);

    }


    public void updateAirCompanyForSingleAirplane(int serialNumberOfPlane,String newNameOfAirCompany){

        int newNameID = getAirCompanyByName(newNameOfAirCompany);

        airplaneRepository.updateAirCompanyForSingleAirplane(newNameID,serialNumberOfPlane);


    }






}
