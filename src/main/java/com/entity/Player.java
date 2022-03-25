package com.entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "players")
@Getter
@Setter
@ToString
public class Player {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;


    @Column(name = "full_name")
    @Size(min = 2,max = 48,message = "Size must be between 2 and 48 symbol")
    @NotBlank(message = "Please input data")
    private String   fullName;

    @NotNull
    @Min(value = 1, message = "Age should be equal or more than 1")
    @Max(value = 100, message = "Age should be equal or less than 100")
    @Column(name = "age")
    private int   age;

    @Size(min = 1,max = 16,message = "Size must be between 2 and 16 symbol")
    @NotBlank(message = "Please input data")
    @Column(name = "position")
    private String   position;

    @Pattern( regexp = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$")
    @NotBlank(message = "Please input date")
    @Column(name = "career_start_from")
    private String   career_start_from;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "football_teams_id")
    private FootballTeam footballTeam;


    public Player(String fullName, int age, String position, String career_start_from) {
        this.fullName = fullName;
        this.age = age;
        this.position = position;
        this.career_start_from = career_start_from;
    }

    public Player(String fullName, int age, String position, String career_start_from, FootballTeam footballTeam) {
        this.fullName = fullName;
        this.age = age;
        this.position = position;
        this.career_start_from = career_start_from;
        this.footballTeam = footballTeam;
    }

    public Player() {
    }
}
