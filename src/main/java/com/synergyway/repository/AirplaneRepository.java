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
    public int getAirCompanyByName(@Param("nameOfCompany") String nameOfCompany);

    @Query(value = "select id from `airplane` WHERE factory_serial_number = :factorySerialNumber  ;",nativeQuery = true)
    public int getAirplaneByFactorySerialNumber(@Param("factorySerialNumber") int factorySerialNumber);

    @Modifying
    @Transactional
    @Query(value = "UPDATE airplane SET air_company_id = :newId WHERE air_company_id = :oldId",nativeQuery = true)
    public void updateAirCompanyForAirplane( @Param("newId") int newId , @Param("oldId") int oldId );


    @Modifying
    @Transactional
    @Query(value = "UPDATE airplane SET air_company_id = :newId WHERE factory_serial_number = :serialNumber ",nativeQuery = true)
    public void updateAirCompanyForSingleAirplane( @Param("newId") int newId , @Param("serialNumber") int serialNumber );

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO airplane (name, factory_serial_number, number_of_flight, flight_distance, fuel_capacity, type, created_at, air_company_id)\n" +
            "       VALUES (:name , :factorySerialNumber ,:numberOfFlight , :flightDistance , :fuelCapacity , :type , :createdAt , :airCompanyId ) ",nativeQuery = true)
    public void addAirplaneToCompany( @Param("name") String name , @Param("factorySerialNumber") int factorySerialNumber , @Param("numberOfFlight")  String numberOfFlight
                                    , @Param("flightDistance") int flightDistance , @Param("fuelCapacity") int fuelCapacity , @Param("type") String type
                                    , @Param("createdAt") String createdAt , @Param("airCompanyId") int airCompanyId   );





}
