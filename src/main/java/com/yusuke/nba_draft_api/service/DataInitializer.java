
package com.yusuke.nba_draft_api.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yusuke.nba_draft_api.model.Player;
import com.yusuke.nba_draft_api.model.Team;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final TeamService teamService;
    private final PlayerService playerService;
    private final ObjectMapper objectMapper;

    @Override
    public void run(String... args) {
        log.info("Starting data initialization...");

        loadTeams();
        loadPlayers();

        log.info("Data initialization completed successfully.");
    }

    private void loadTeams() {
        log.info("Importing teams...");
        try (InputStream inputStream = getClass().getResourceAsStream("/team-data.json")) {
            if (inputStream == null) {
                log.error("File team-data.json not found!");
                return;
            }
            List<Team> teams = objectMapper.readValue(inputStream, new TypeReference<List<Team>>(){});
            teamService.importOrUpdateTeams(teams);
            log.info("{} teams processed.", teams.size());
        } catch (IOException e) {
            log.error("Failed to import teams: {}", e.getMessage());
        }
    }

    private void loadPlayers() {
        log.info("Importing players...");
        try (InputStream inputStream = getClass().getResourceAsStream("/players-data.json")) {
            if (inputStream == null) {
                log.error("File players-data.json not found!");
                return;
            }
            List<Player> players = objectMapper.readValue(inputStream, new TypeReference<List<Player>>() {});
            playerService.importOrUpdatePlayers(players);
            log.info("{} players processed.", players.size());
        } catch (IOException e) {
            log.error("Failed to import players: {}", e.getMessage());
        }
    }
}