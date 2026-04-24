package com.yusuke.nba_draft_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="teams")
@Getter
@Setter
@NoArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String teamCode;

    private String name;

    @Column(unique = true)
    private String logoUrl;

    private String primaryColor;
    public void updateFrom(Team source) {
        this.teamCode = source.getTeamCode();
        this.name = source.getName();
        this.logoUrl = source.getLogoUrl();
        this.primaryColor = source.getPrimaryColor();
    }
}