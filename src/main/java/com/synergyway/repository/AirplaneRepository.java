package com.synergyway.repository;

import com.synergyway.entity.AirCompany;
import com.synergyway.entity.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane,Long> {


    @Query(value = "select id from `air_company` WHERE name = :nameOfCompany  ;",nativeQuery = true)
    public int getAirplaneIdByName(@Param("nameOfCompany") String nameOfCompany);

    @Modifying
    @Transactional
    @Query(value = "UPDATE airplane SET air_company_id = :newId WHERE air_company_id = :oldId",nativeQuery = true)
    public void updateAirCompanyForAirplane( @Param("newId") int newId , @Param("oldId") int oldId );


    @Modifying
    @Transactional
    @Query(value = "UPDATE airplane SET air_company_id = :newId WHERE factory_serial_number = :serialNumber ",nativeQuery = true)
    public void updateAirCompanyForSingleAirplane( @Param("newId") int newId , @Param("serialNumber") int serialNumber );



}
