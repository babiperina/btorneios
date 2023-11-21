package com.example.score4you.categoriaTorneio;

public record CategoriaTorneioResponseDTO(Long id, Integer categoria_id, Integer torneio_id) {
    public CategoriaTorneioResponseDTO(CategoriaTorneio categoriaTorneio) {
        this(categoriaTorneio.getId(), categoriaTorneio.getCategoria_id(), categoriaTorneio.getTorneio_id());
    }

}
