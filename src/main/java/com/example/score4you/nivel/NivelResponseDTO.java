package com.example.score4you.nivel;

import com.example.score4you.genero.Genero;

public record NivelResponseDTO(Long id, String name) {
    public NivelResponseDTO(Nivel nivel) {
        this(nivel.getId(), nivel.getName());
    }

}
