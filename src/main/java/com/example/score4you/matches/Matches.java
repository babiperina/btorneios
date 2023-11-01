package com.example.score4you.matches;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "matches")
@Entity(name = "matches")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "match_id")
public class Matches {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long match_id;
    private Long winner_id;
    private Long loser_id;

    public Matches(MatchRequestDTO data) {
        this.winner_id = data.winner_id();
        this.loser_id = data.loser_id();
    }
}
