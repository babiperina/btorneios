package com.example.score4you.torneio;

// Response body
public record TorneioResponseDTO(Long id, String name, Integer quantidade_min_duplas, String configuracao_game_set, Integer status_id){
    public TorneioResponseDTO(Torneio torneio) {
        this(torneio.getId(), torneio.getName(), torneio.getQuantidade_min_duplas(), torneio.getConfiguracao_game_set(), torneio.getStatus_id());
    }
}
