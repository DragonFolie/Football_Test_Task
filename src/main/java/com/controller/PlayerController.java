package com.controller;


import com.entity.Player;
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
@Validated
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
    public ResponseEntity<Player> addNewPlayer(@Valid @RequestBody Player player,@PathVariable("team_name")String team_name, BindingResult bindingResult){

        playerService.addNewPlayer(player,team_name);
        return ResponseEntity.ok().build() ;

    }

    @PutMapping(path = "/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Player> updatePlayer(@Valid @RequestBody Player player, BindingResult bindingResult){

        playerService.updatePlayer(player);
        return ResponseEntity.ok().build() ;

    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Player> deleteById(@PathVariable("id")Long id){

        playerService.deleteById(id);
        return ResponseEntity.ok().build() ;

    }

//    http://localhost:8080/player/transfer/8/4/5
    @PostMapping(path = "/playerTransfer/{idPlayer}/{idOldTeam}/{idNewTeam}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Player> transfer( @PathVariable("idPlayer")Long idPlayer, @PathVariable("idOldTeam")Long idOldTeam, @PathVariable("idNewTeam")Long idNewTeam){

        playerService.transfer(idOldTeam,idNewTeam,idPlayer);
        return ResponseEntity.ok().build() ;

    }









}
