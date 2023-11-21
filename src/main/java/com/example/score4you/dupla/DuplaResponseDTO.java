package com.example.score4you.dupla;

public record DuplaResponseDTO(Long id, Integer jogadorA, Integer jogadorB) {
    public DuplaResponseDTO(Dupla dupla) {
        this(dupla.getId(), dupla.getJogadorA(), dupla.getJogadorB());
    }

}
