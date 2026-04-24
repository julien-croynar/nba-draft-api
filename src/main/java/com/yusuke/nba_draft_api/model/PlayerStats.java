package com.yusuke.nba_draft_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "stats")
@Getter
@Setter
@NoArgsConstructor
public class PlayerStats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double points;
    private double rebound;
    private double assists;
    private int gamePlayed;
    private String position;
    public void updateFrom(PlayerStats source) {
        this.points = source.points;
        this.rebound = source.rebound;
        this.assists = source.assists;
        this.gamePlayed = source.gamePlayed;
        this.position = source.position;
    }
}

