package com.controller;


import com.entity.Player;
import com.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;


    @GetMapping(path = "/")
    @ResponseStatus(HttpStatus.OK)
    public List<Player> findAllPlayers(){

        return playerService.findAllPlayers();

    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Player> findPlayerById(@PathVariable("id") Long id){

        return playerService.findPlayerById(id);

    }


    @PostMapping(path = "/{team_name}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Player> addNewPlayer(@RequestBody Player player,@PathVariable("team_name")String team_name){

        playerService.addNewPlayer(player,team_name);
        return ResponseEntity.ok().build() ;

    }

    @PutMapping(path = "/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player){

        playerService.updatePlayer(player);
        return ResponseEntity.ok().build() ;

    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Player> deleteById(@PathVariable("id")Long id){

        playerService.deleteById(id);
        return ResponseEntity.ok().build() ;

    }








}
