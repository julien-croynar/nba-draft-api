package com.yusuke.nba_draft_api.dto;

import com.yusuke.nba_draft_api.model.Player;

public record PlayerBasicInfoDTO (
    long id,
    String name,
    String teamId,
    String headShotPath,
    String position

){
    public PlayerBasicInfoDTO(Player player) {
        this(
                player.getId(),
                player.getName(),
                player.getTeamId(),
                player.getHeadShotPath(),
                player.getStats() != null ? player.getStats().getPosition() : "N/A"
        );
    }

}