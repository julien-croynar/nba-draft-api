package com.yusuke.nba_draft_api.repository;

import com.yusuke.nba_draft_api.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team,Long> {
    Optional<Team> findByTeamCode(String teamCode);
}
