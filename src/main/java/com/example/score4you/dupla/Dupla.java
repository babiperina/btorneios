package com.example.score4you.dupla;

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
public class Dupla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer jogadorA;
    private Integer jogadorB;

    public Dupla(DuplaRequestDTO data) {
        this.jogadorA = data.jogadorA();
        this.jogadorB = data.jogadorB();
    }
}
