package com.synergyway.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "air_company")
@Getter
@ToString
@RequiredArgsConstructor
public class AirCompany {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "company_type")
    private String companyType;

    @Column(name = "founded_at")
    private String foundedAt;


//
//
//    @OneToMany(cascade = CascadeType.ALL,mappedBy = "airCompany")
//    private List<Airplane> airCompany;
//
//    @OneToMany(cascade = CascadeType.ALL,mappedBy = "airCompanyId")
//    private List<Flight> airCompanyId;

    public AirCompany(String name, String companyType, String foundedAt) {
        this.name = name;
        this.companyType = companyType;
        this.foundedAt = foundedAt;
    }


}
