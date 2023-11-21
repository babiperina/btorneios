package com.example.score4you.status;

public record StatusResponseDTO(Long id, String name) {
    public StatusResponseDTO(Status status) {
        this(status.getId(), status.getName());
    }
}
