package com.synergyway.repository;

import com.synergyway.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {

    @Query(value = "UPDATE flight SET  air_Company_id = :newAirCompanyId WHERE air_Company_id = :oldAirCompanyID",nativeQuery = true)
    public List<Flight> updateCompanyId();


    @Query(value = "select id from `air_company` WHERE name = :nameOfCompany  ;",nativeQuery = true)
    public int getAirplaneIdByName(@Param("nameOfCompany") String nameOfCompany);


    @Query(value = "select * from flight WHERE air_Company_id = :id AND flight_status = 'ACTIVE' ;",nativeQuery = true)
    public List<Flight> getFlightWithActiveStatusAndLessThan24Hour(@Param("id") int id);


    @Query(value = "select id from `air_company` WHERE name = :nameOfCompany  ;",nativeQuery = true)
    public int ggg(@Param("nameOfCompany") String nameOfCompany);


}
