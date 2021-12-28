package com.synergyway.service;

import com.synergyway.entity.AirCompany;
import com.synergyway.repository.AirCompanyRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class AirCompanyService {


    private AirCompanyRepository airCompanyRepository;

    @Autowired
    public void setAirCompanyRepository(AirCompanyRepository airCompanyRepository) {
        this.airCompanyRepository = airCompanyRepository;
    }

    public List<AirCompany> findAll(){

        return airCompanyRepository.findAll();

    }


    public Object addCompany(AirCompany airCompany) {

        return  airCompanyRepository.save(airCompany);

    }


    public void deleteCompany(Long id)
    {
          airCompanyRepository.deleteById(id);
    }


    public void updateNameCompany(AirCompany airCompany)
    {
        airCompanyRepository.save(airCompany);
    }

}
