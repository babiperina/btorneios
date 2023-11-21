package com.example.score4you.duplaTorneio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "dupla_torneio")
@Entity(name = "dupla_torneio")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class DuplaTorneio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer dupla_id;
    private Integer torneio_id;

    public DuplaTorneio(DuplaTorneioRequestDTO data) {
        this.dupla_id = data.dupla_id();
        this.torneio_id = data.torneio_id();
    }
}
