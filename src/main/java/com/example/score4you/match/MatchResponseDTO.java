package com.example.score4you.match;

public record MatchResponseDTO (Long match_id, Long winner_id, Long loser_id){
    public MatchResponseDTO(Match match) {
        this(match.getMatch_id(), match.getWinner_id(), match.getLoser_id());
    }
}
