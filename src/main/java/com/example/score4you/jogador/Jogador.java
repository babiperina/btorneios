package com.example.score4you.jogador;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "jogador")
@Entity(name = "jogador")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer genero_id;
    private Integer nivel_id;

    public Jogador(JogadorRequestDTO data) {
        this.name = data.name();
        this.genero_id = data.genero_id();
        this.nivel_id = data.nivel_id();
    }
}
