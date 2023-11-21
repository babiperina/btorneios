package com.example.score4you.categoria;

import com.example.score4you.controller.GeneroController;
import com.example.score4you.controller.NivelController;
import com.example.score4you.genero.GeneroRepository;
import com.example.score4you.nivel.Nivel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "categoria")
@Entity(name = "categoria")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer genero_id;
    private String genero_name;
    private Integer nivel_id;
    private String nivel_name;

    public Categoria(CategoriaRequestDTO data) {
        this.name = data.name();
        this.genero_id = data.genero_id();
        this.nivel_id = data.nivel_id();
    }
}
