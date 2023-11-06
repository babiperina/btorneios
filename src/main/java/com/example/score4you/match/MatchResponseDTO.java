package com.example.score4you.match;

// Response body
public record MatchResponseDTO (Long id, String match_name, Long team_a, Long team_b, String winner, Long sport_id){
    public MatchResponseDTO(Match match) {
        this(match.getId(), match.getMatch_name(), match.getTeam_a(),  match.getTeam_b(),  match.getWinner(), match.getSport_id());
    }
}
