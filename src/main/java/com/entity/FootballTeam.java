package com.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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

//    @OneToMany(mappedBy="footballTeam")
//    private Set<Player> items;



    public FootballTeam( String name, String owner) {

        this.name = name;
        this.owner = owner;
    }

    public FootballTeam() {
    }
}
