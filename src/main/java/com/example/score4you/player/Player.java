package com.example.score4you.player;

import com.example.score4you.match.MatchRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "player")
@Entity(name = "player")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "player_id")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long player_id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone;

    public Player(PlayerRequestDTO data) {
        this.player_id= data.player_id();
        this.first_name = data.first_name();
        this.last_name = data.last_name();
        this.email = data.email();
        this.phone = data.phone();
    }
}

