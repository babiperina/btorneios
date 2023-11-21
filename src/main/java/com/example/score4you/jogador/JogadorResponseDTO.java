package com.example.score4you.jogador;

public record JogadorResponseDTO(Long id, Integer genero_id,  Integer nivel_id) {
    public JogadorResponseDTO(Jogador jogador) {
        this(jogador.getId(), jogador.getGenero_id(), jogador.getNivel_id());
    }

}
