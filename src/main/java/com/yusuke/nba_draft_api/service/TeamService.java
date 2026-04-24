package com.yusuke.nba_draft_api.service;

import com.yusuke.nba_draft_api.model.Team;
import com.yusuke.nba_draft_api.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;
    public List<Team> getAllTeam() {return teamRepository.findAll();}

    public void importOrUpdateTeams(List<Team> teams) {
        for (Team team : teams) {
            teamRepository.findByTeamCode(team.getTeamCode())
                    .ifPresentOrElse(
                            existingTeam -> {
                                existingTeam.updateFrom(team);
                                teamRepository.save(existingTeam);
                            },
                            () -> teamRepository.save(team)
                    );
        }
    }
}
