package com.example.score4you.sport;

// Response body
public record SportResponseDTO(Long id, String sport_name){
    public SportResponseDTO(Sport match) {
        this(match.getId(), match.getSport_name());
    }
}
