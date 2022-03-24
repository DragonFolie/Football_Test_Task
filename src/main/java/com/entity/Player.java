package com.entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "players")
@Getter
@ToString
public class Player {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String   fullName;

    @Column(name = "age")
    private int   age;

    @Column(name = "position")
    private String   position;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "football_teams_id")
    private FootballTeam footballTeam;

    public Player( String fullName, int age, String position) {

        this.fullName = fullName;
        this.age = age;
        this.position = position;
    }



    public Player() {
    }
}
