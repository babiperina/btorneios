package com.example.score4you.torneio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "torneio")
@Entity(name = "torneio")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Torneio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer quantidade_min_duplas;
    private String configuracao_game_set;
    private Integer status_id;

    public Torneio(TorneioRequestDTO data) {
        this.name = data.name();
        this.status_id = 1;
    }
}
