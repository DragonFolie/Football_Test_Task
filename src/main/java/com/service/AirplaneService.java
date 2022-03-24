//package com.service;
//
//
//import com.synergyway.entity.AirCompany;
//import com.synergyway.entity.Airplane;
//import com.synergyway.repository.AirCompanyRepository;
//import com.synergyway.repository.AirplaneRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class AirplaneService {
//
//    private AirplaneRepository airplaneRepository;
//    private AirCompanyRepository airCompanyRepository;
//
//    @Autowired
//    public void setAirCompany(AirCompanyRepository airCompanyRepository) {
//        this.airCompanyRepository = airCompanyRepository;
//    }
//
//    @Autowired
//    public void setAirplaneRepository(AirplaneRepository airplaneRepository) {
//        this.airplaneRepository = airplaneRepository;
//    }
//
//
//    public void addAirplaneToCompany(String companyName , Airplane airplane ){
//
//
//        AirCompany airCompany =  airCompanyRepository.findByName(companyName);
//        airplane.setAirCompany(airCompany);
//        airplaneRepository.save(airplane);
//
//
//    }
//
//
//
//    public List<Airplane> getAllAirplanes(){
//
//        return airplaneRepository.findAll();
//
//    }
//
//
//    public int getAirCompanyByName(String name) {
//
//
//        return airplaneRepository.getAirCompanyIdByName(name);
//
//    }
//
//
//    public void updateAirCompanyForAirplanes(String oldName,String newName){
//
//        int oldNameID = getAirCompanyByName(oldName);
//        int newNameID = getAirCompanyByName(newName);
//
//        airplaneRepository.updateAirCompanyForAirplane(newNameID,oldNameID);
//
//    }
//
//
//    public Airplane updateAirCompanyForSingleAirplane(Airplane airplane){
//
//       return airplaneRepository.save(airplane);
//
//
//    }
//
//
//
//
//
//
//}
