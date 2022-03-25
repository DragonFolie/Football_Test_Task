package com.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "football_teams")
@Setter
@Getter
@ToString
public class FootballTeam {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;


    @Column(name = "name")
    @Size(min = 2,max = 48,message = "Size must be between 2 and 48 symbol")
    @NotBlank(message = "Please input data")
    private String name;


    @Column(name = "owner")
    @Size(min = 2,max = 48,message = "Size must be between 2 and 48 symbol")
    @NotBlank(message = "Please input data")
    private String owner;


    @Column(name = "transfer_fee")
    @NotNull(message = "Please input data")
    private int transfer_fee;


    @Column(name = "balance")
    @NotNull
    private int balance;


    public FootballTeam(String name, String owner, int transfer_fee, int balance) {
        this.name = name;
        this.owner = owner;
        this.transfer_fee = transfer_fee;
        this.balance = balance;
    }

    public FootballTeam() {
    }
}
