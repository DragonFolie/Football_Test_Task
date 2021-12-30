package com.synergyway.repository;


import com.synergyway.entity.AirCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface AirCompanyRepository extends JpaRepository<AirCompany,Long> {

    @Query(value = "select * from `air_company`;",nativeQuery = true)
    public List<AirCompany> getAllDetails();





    @Modifying
    @Query(value ="UPDATE air_company Set name = :name Where id = :id;",nativeQuery = true)
    public List<AirCompany> updateNameCompany(@Param("name") String name,@Param("id") int id );


}
