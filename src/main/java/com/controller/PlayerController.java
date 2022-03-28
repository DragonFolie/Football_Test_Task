package com.controller;


import com.entity.Player;
import com.exception_handler.NoSuchPlayerException;
import com.exception_handler.PlayerIncorrectData;
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
@Validated
@RequestMapping(value = "/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;


    @GetMapping(path = "/")
    @ResponseStatus(HttpStatus.OK)
    public List<Player> findAllPlayers(){
        List<Player> list = playerService.findAllPlayers();


        if(list.isEmpty() ){
            throw new NoSuchPlayerException("No such player founded or List of players is empty");
        }

        return list;

    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Player> findPlayerById(@PathVariable("id") Long id){

        Optional<Player> list = playerService.findPlayerById(id);


        if(list.isEmpty()  ){
            throw new NoSuchPlayerException("No such player founded or list of players is empty");
        }

        return list;

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

    @PostMapping(path = "/playerTransfer/{idPlayer}/{idOldTeam}/{idNewTeam}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Player> transfer( @PathVariable("idPlayer")Long idPlayer, @PathVariable("idOldTeam")Long idOldTeam, @PathVariable("idNewTeam")Long idNewTeam){

        playerService.transfer(idOldTeam,idNewTeam,idPlayer);
        return ResponseEntity.ok().build() ;

    }

    @ExceptionHandler
    public ResponseEntity<PlayerIncorrectData> handle_exception(NoSuchPlayerException exception){
        PlayerIncorrectData data = new PlayerIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data,HttpStatus.NOT_FOUND);

    }

//    @ExceptionHandler
//    public ResponseEntity<PlayerIncorrectData> handle_exception(Exception exception){
//        PlayerIncorrectData data = new PlayerIncorrectData();
//        data.setInfo(exception.getMessage());
//
//        return new ResponseEntity<>(data,HttpStatus.BAD_REQUEST);
//
//    }

    @ExceptionHandler
    public ResponseEntity<PlayerIncorrectData> handle_exception(EntityNotFoundException exception){
        PlayerIncorrectData data = new PlayerIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data,HttpStatus.BAD_REQUEST);

    }








}
