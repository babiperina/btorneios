package com.example.score4you.matches;

import com.example.score4you.matches.Matches;

public record MatchResponseDTO (Long match_id, Long winner_id, Long loser_id){
    public MatchResponseDTO(Matches match) {
        this(match.getMatch_id(), match.getWinner_id(), match.getLoser_id());
    }
}
