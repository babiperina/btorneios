package com.example.score4you.match;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "match")
@Entity(name = "match")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "match_id")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long match_id;
    private Long winner_id;
    private Long loser_id;

    public Match(MatchRequestDTO data) {
        this.winner_id = data.winner_id();
        this.loser_id = data.loser_id();
    }
}
