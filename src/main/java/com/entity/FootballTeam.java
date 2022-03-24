package com.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "football_teams")
@Getter
@ToString
public class FootballTeam {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "owner")
    private String owner;





    public FootballTeam( String name, String owner) {

        this.name = name;
        this.owner = owner;
    }

    public FootballTeam() {
    }
}
