package com.service;

import com.entity.Player;
import com.repository.PlayerRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class PlayerService {


    private PlayerRepository playerRepository;


    @Autowired
    public void setPlayerRepository(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> findAllPlayers(){
        return  playerRepository.findAll();
    }







}
