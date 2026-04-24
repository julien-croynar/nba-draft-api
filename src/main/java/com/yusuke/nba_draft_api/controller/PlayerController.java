package com.yusuke.nba_draft_api.controller;

import com.yusuke.nba_draft_api.dto.PlayerBasicInfoDTO;
import com.yusuke.nba_draft_api.model.Player;
import com.yusuke.nba_draft_api.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
@CrossOrigin(origins = "${app.cors.origins}")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers(){
        return new ResponseEntity<>(playerService.getAllPlayers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerByID(@PathVariable Long id){
        return playerService.getPlayerById(id)
                .map(player -> new ResponseEntity<>(player, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/team/{teamId}")
    public ResponseEntity<List<Player>> getPlayersByTeamCode(@PathVariable String teamId) {
        return new ResponseEntity<>(playerService.getPlayersByTeamCode(teamId),HttpStatus.OK);
    }

    @GetMapping("/team/{teamId}/id")
    public ResponseEntity<List<Long>> getPlayersIdByTeam(@PathVariable String teamId) {
        List<Long> players = playerService.getPlayersIdByTeamCode(teamId);
        return new ResponseEntity<>(players,HttpStatus.OK);
    }

    @GetMapping("/basic")
    public ResponseEntity<List<PlayerBasicInfoDTO>> getAllPlayersBasic() {
        List<PlayerBasicInfoDTO> dtos = playerService.getAllPlayers().stream()
                .map(PlayerBasicInfoDTO::new)
                .toList();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
}
