package com.example.score4you.categoria;

public record CategoriaResponseDTO(Long id, String name, Integer genero_id, String genero_name, Integer nivel_id, String nivel_name) {
    public CategoriaResponseDTO(Categoria nivel) {
        this(nivel.getId(), nivel.getName(), nivel.getGenero_id(), nivel.getGenero_name(), nivel.getNivel_id(), nivel.getNivel_name());
    }

}
