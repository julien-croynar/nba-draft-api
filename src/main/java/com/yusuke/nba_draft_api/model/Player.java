package com.yusuke.nba_draft_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="players")
@Getter
@Setter
@NoArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String teamId;
    private int age;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contract_id")
    private PlayerContract contract;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stats_id")
    private PlayerStats stats;
    @Column(unique = true)
    private String headShotPath;
    public void updateFrom(Player source) {
        this.name = source.getName();
        this.teamId = source.getTeamId();
        this.age = source.getAge();
        this.headShotPath = source.getHeadShotPath();

        if (this.contract != null && source.getContract() != null) {
            this.contract.updateFrom(source.getContract());
        }

        if (this.stats != null && source.getStats() != null) {
            this.stats.updateFrom(source.getStats());
        }
    }
}
