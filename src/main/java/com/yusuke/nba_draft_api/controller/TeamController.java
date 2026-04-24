package com.yusuke.nba_draft_api.controller;

import com.yusuke.nba_draft_api.model.Team;
import com.yusuke.nba_draft_api.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
@CrossOrigin(origins = "${app.cors.origins}")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;
    @GetMapping
    public ResponseEntity<List<Team>> getAllTeams(){
        return new ResponseEntity<>(teamService.getAllTeam(), HttpStatus.OK);
    }

}
