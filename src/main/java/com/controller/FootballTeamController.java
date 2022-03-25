package com.controller;


import com.entity.FootballTeam;
import com.entity.Player;
import com.service.FootballTeamService;
import com.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/football")
@Validated
public class FootballTeamController {

    @Autowired
    private FootballTeamService footballTeamService;


    @GetMapping(path = "/")
    @ResponseStatus(HttpStatus.OK)
    public List<FootballTeam> findAllPlayers(){

        return footballTeamService.findAllTeam();

    }



    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<FootballTeam> findById(@PathVariable("id")Long id){

        return footballTeamService.findById(id);

    }



    @PostMapping(path = "/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Player> addNewTeam( @Valid @RequestBody FootballTeam footballTeam ){

        footballTeamService.addNewTeam(footballTeam);
        return ResponseEntity.ok().build() ;

    }



    @PutMapping(path = "/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Player> updateTeam(@Valid @RequestBody FootballTeam footballTeam){

        footballTeamService.updateTeam(footballTeam);
        return ResponseEntity.ok().build() ;

    }


    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Player> deleteTeam(@PathVariable("id")Long id){

        footballTeamService.deleteTeam(id);
        return ResponseEntity.ok().build() ;

    }








}
