package com.repository;

import com.entity.FootballTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FootballTeamRepository extends JpaRepository<FootballTeam,Long> {

    public FootballTeam findByName(String team_name);

}
