package com.yusuke.nba_draft_api.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contracts")
@Getter
@Setter
@NoArgsConstructor
public class PlayerContract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long capHit;
    private long nextSeasonEarning;
    private int seasonRemaining;
    @Enumerated(EnumType.STRING)
    private ContractOption option;

    public void updateFrom(PlayerContract source) {
        this.capHit = source.capHit;
        this.option = source.option;
        this.seasonRemaining = source.seasonRemaining;
        this.nextSeasonEarning = source.nextSeasonEarning;

    }

}
