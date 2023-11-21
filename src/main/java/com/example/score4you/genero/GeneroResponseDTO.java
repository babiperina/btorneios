package com.example.score4you.genero;

public record GeneroResponseDTO(Long id, String name) {
    public GeneroResponseDTO(Genero genero) {
        this(genero.getId(), genero.getName());
    }
}
