package com.synergyway.repository;

import com.synergyway.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {

    @Query(value = "UPDATE flight SET  air_Company_id = :newAirCompanyId WHERE air_Company_id = :oldAirCompanyID",nativeQuery = true)
    public List<Flight> updateCompanyId();


}
