package com.service;

import com.entity.FootballTeam;
import com.entity.Player;
import com.repository.FootballTeamRepository;
import com.repository.PlayerRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class FootballTeamService {

    private FootballTeamRepository footballTeamRepository;

    @Autowired
    public void setFootballTeamRepository(FootballTeamRepository footballTeamRepository) {
        this.footballTeamRepository = footballTeamRepository;
    }

    public List<FootballTeam> findAllTeam(){

        return  footballTeamRepository.findAll();

    }







}
