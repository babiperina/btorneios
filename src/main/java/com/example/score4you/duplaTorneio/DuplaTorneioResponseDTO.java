package com.example.score4you.duplaTorneio;

public record DuplaTorneioResponseDTO(Long id, Integer dupla_id, Integer torneio_id) {
    public DuplaTorneioResponseDTO(DuplaTorneio duplaTorneio) {
        this(duplaTorneio.getId(), duplaTorneio.getDupla_id(), duplaTorneio.getTorneio_id());
    }

}
