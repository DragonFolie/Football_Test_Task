package com.controller;


import com.entity.Player;
import com.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/player")
public class PlayerController {

    @Autowired
    private PlayerService player;


    @GetMapping(path = "/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Player> findAllPlayers(){

        return player.findAllPlayers();

    }








}
