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
import java.util.Optional;

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

    public Optional<FootballTeam> findById(Long id){

        return  footballTeamRepository.findById(id);
    }


    public void addNewTeam(FootballTeam footballTeam){

        footballTeamRepository.save(footballTeam);

    }

    public void updateTeam(FootballTeam footballTeam){

        footballTeamRepository.save(footballTeam);

    }


    public void deleteTeam(Long id){

        footballTeamRepository.deleteById(id);

    }











}
