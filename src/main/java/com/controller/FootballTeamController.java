package com.controller;


import com.entity.FootballTeam;
import com.entity.Player;
import com.service.FootballTeamService;
import com.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/football")
public class FootballTeamController {

    @Autowired
    private FootballTeamService footballTeamService;


    @GetMapping(path = "/all")
    @ResponseStatus(HttpStatus.OK)
    public List<FootballTeam> findAllTeam(){

        return footballTeamService.findAllTeam();

    }


}
