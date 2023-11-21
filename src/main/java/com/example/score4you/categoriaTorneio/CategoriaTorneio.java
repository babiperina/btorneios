package com.example.score4you.categoriaTorneio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "categoria_torneio")
@Entity(name = "categoria_torneio")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class CategoriaTorneio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer categoria_id;
    private Integer torneio_id;

    public CategoriaTorneio(CategoriaTorneioRequestDTO data) {
        this.categoria_id = data.categoria_id();
        this.torneio_id = data.torneio_id();
    }
}
