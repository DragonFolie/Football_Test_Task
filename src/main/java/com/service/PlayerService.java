package com.service;

import com.classAssistants.TimeHelper;
import com.entity.FootballTeam;
import com.entity.Player;
import com.repository.FootballTeamRepository;
import com.repository.PlayerRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import static com.classAssistants.TimeHelper.monthAgoFrom;

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


    public void transfer(Long idTeamFrom,Long idTeamTo,Long idPlayer){

        FootballTeam transferFrom = footballTeamRepository.getById(idTeamFrom);
        FootballTeam transferTo = footballTeamRepository.getById(idTeamTo);
        Player player = playerRepository.getById(idPlayer);
        TimeHelper timeHelper = new TimeHelper();

        System.out.println(transferFrom + "    " + transferFrom + "     " + player);
        String experienceFrom = player.getCareer_start_from();
        long experienceNow = 0;
        try {
            System.out.println(experienceNow + "   ++ " );
            System.out.println(experienceFrom + "  ////  " );
             experienceNow =  monthAgoFrom(experienceFrom); // готовий досвід
            System.out.println(experienceNow + "  --  " );
        } catch (ParseException e) {
            e.printStackTrace();
        }


        int age = player.getAge();
        int transfer_fee = transferTo.getTransfer_fee();

        long transferCostWOFee = (experienceNow  * 100000 / age) ;
        long transferWithFee = ( transferCostWOFee *  (transfer_fee / 100) ) + transferCostWOFee;

        int balanceFrom = transferFrom.getBalance();
        int balanceTo = transferTo.getBalance();

        System.out.println(age + "  a  " + transfer_fee + " a   " + transferCostWOFee + " a   " + transferWithFee + "   a " + balanceFrom + "    " + balanceTo);

        balanceFrom -= transferWithFee;
        transferFrom.setBalance(balanceFrom);
        footballTeamRepository.save(transferFrom);

        System.out.println("Done 1");
        balanceTo += transferWithFee;
        transferTo.setBalance(balanceTo);
        footballTeamRepository.save(transferTo);

        System.out.println("Done 2");

        player.setFootballTeam(transferTo);
        playerRepository.save(player);

        System.out.println("Done 3");

    }

//    вартість трансферу = кількість місяців досвіду гравця * 100000 / вік гравця у роках
//    комісія зі сторони команди (від 0% до 10% від вартості трансферу) - вказується в інформації про команду
//    повна сума (вартість трансферу + комісія) повинна зніматись з рахунку команди,
//    яка купує гравця, і переходити на рахунок команди, яка продає



    public void deleteById(Long id){

          playerRepository.deleteById(id);

    }








}
