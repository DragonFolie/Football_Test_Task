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
public class PlayerService {


    private PlayerRepository playerRepository;
    private FootballTeamRepository footballTeamRepository;



    @Autowired
    public void setPlayerRepository(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Autowired
    public void setFootballTeamRepository(FootballTeamRepository footballTeamRepository) {
        this.footballTeamRepository = footballTeamRepository;
    }

    public List<Player> findAllPlayers(){
        return  playerRepository.findAll();
    }


    public Optional<Player> findPlayerById(Long id){
        return  playerRepository.findById(id);
    }


    public Player addNewPlayer(Player player,String team_name){
        FootballTeam footballTeam =  footballTeamRepository.findByName(team_name);
        player.setFootballTeam(footballTeam);
        return  playerRepository.save(player);

    }


    public void updatePlayer(Player player){

        playerRepository.save(player);

    }



    public void deleteById(Long id){

          playerRepository.deleteById(id);

    }








}
