package com.controller;


import com.entity.FootballTeam;
import com.entity.Player;
import com.exception_handler.NoSuchFootballTeamException;
import com.exception_handler.NoSuchPlayerException;
import com.exception_handler.PlayerIncorrectData;
import com.exception_handler.TeamIncorrectData;
import com.service.FootballTeamService;
import com.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
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

        List<FootballTeam> list= footballTeamService.findAllTeam();
        if (list.isEmpty()){
            throw new NoSuchFootballTeamException("No such team founded or list of players is empty");
        }

        return list;

    }



    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<FootballTeam> findById(@PathVariable("id")Long id){

        Optional<FootballTeam> list= footballTeamService.findById(id);
        if (list.isEmpty()){
            throw new NoSuchFootballTeamException("No such team founded or list of players is empty");
        }

        return list;


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


    @ExceptionHandler
    public ResponseEntity<TeamIncorrectData> handle_exception(NoSuchFootballTeamException exception){
        TeamIncorrectData data = new TeamIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data,HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler
    public ResponseEntity<TeamIncorrectData> handle_exception(Exception exception){
        TeamIncorrectData data = new TeamIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data,HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler
    public ResponseEntity<TeamIncorrectData> handle_exception(EntityNotFoundException exception){
        TeamIncorrectData data = new TeamIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data,HttpStatus.NOT_FOUND);

    }







}
