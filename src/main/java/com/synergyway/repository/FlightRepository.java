package com.synergyway.repository;

import com.synergyway.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {


    @Query(value = "select id from `air_company` WHERE name = :nameOfCompany  ;",nativeQuery = true)
    public int getAirplaneIdByName(@Param("nameOfCompany") String nameOfCompany);




    @Query(value = "select * from flight WHERE air_Company_id = :id AND flight_status = 'ACTIVE' ;",nativeQuery = true)
    public List<Flight> getFlightWithActiveStatus(@Param("id") int id);

    @Query(value = "select * from flight WHERE  flight_status = 'COMPLETED' ;",nativeQuery = true)
    public List<Flight> getAllFlightWithCompletedStatus();


    @Modifying
    @Query(value = "UPDATE flight SET  air_Company_id = :newAirCompanyId WHERE air_Company_id = :oldAirCompanyID",nativeQuery = true)
    public List<Flight> updateCompanyId();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO flight (flight_status, distance, departure_country, destination_country, created_at, ended_at, estimated_flight_time, delay_started_at, airplane_id, air_Company_id) \n" +
            "    VALUES ('PENDING' , :distance ,:departureCountry , :destinationCountry , :createdAt , :endedAt , :estimatedFlightTime , :delay_startedAt , :airplaneId , :airCompanyId ) ",nativeQuery = true)
    public void addFlight(  @Param("distance") int distance , @Param("departureCountry")  String departureCountry
            , @Param("destinationCountry") String destinationCountry , @Param("createdAt") String createdAt , @Param("endedAt") String endedAt
            , @Param("estimatedFlightTime") String estimatedFlightTime , @Param("delay_startedAt") String delay_startedAt ,
                           @Param("airplaneId") int airplaneId , @Param("airCompanyId") int airCompanyId   );



    @Modifying
    @Transactional
    @Query(value = "UPDATE flight Set flight_status = 'DELAYED' , delay_started_at = :delayDateTime WHERE id = :id ;",nativeQuery = true)
    public void updateFlightStatusAndSetDelay(@Param("delayDateTime") String delayDateTime , @Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE flight Set flight_status = 'COMPLETED'  WHERE id = :id ;",nativeQuery = true)
    public void updateFlightStatusAndSetCompleteTime( @Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE flight Set flight_status = 'ACTIVE' , created_at = :startedAt WHERE id = :id ;",nativeQuery = true)
    public void updateFlightStatusAndSetStartedTime(@Param("startedAt") String startAtDateTime , @Param("id") int id);


}
