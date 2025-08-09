package com.md.statstorage.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "tournaments") // table name in supabase
public class EventEntity {

    // Values
    @Id
    @GeneratedValue
    private Long id;
    private String matchId;
    private List<String> teamOnePlayers;
    private List<String> teamTwoPlayers;
    private boolean teamOneWon;
    private String score;


    // Getters/setters - not using lombok for practice purposes

    public String getMatchId(){
        return matchId;
    }
}
