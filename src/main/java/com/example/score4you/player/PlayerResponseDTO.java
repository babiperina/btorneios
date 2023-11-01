package com.example.score4you.player;

import com.example.score4you.player.Player;

public record PlayerResponseDTO(String first_name, String last_name, String email, String phone){
    public PlayerResponseDTO(Player player) {
        this(player.getFirst_name(), player.getLast_name(), player.getEmail(), player.getPhone());
    }
}
