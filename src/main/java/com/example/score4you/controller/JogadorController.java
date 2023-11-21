package com.example.score4you.controller;

import com.example.score4you.categoria.CategoriaRequestDTO;
import com.example.score4you.jogador.Jogador;
import com.example.score4you.jogador.JogadorRepository;
import com.example.score4you.jogador.JogadorRequestDTO;
import com.example.score4you.jogador.JogadorResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("jogador")
public class JogadorController {
    @Autowired
    private JogadorRepository jogadorRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveMatch(@RequestBody JogadorRequestDTO data){
        Jogador jogadorData = new Jogador(data);
        jogadorRepository.save(jogadorData);
        return;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<JogadorResponseDTO> getAll(){
        List<JogadorResponseDTO> jogadores = jogadorRepository.findAll().stream().map(JogadorResponseDTO::new).toList();
        return jogadores;
    }
    @GetMapping("/{id}")
    public Optional<Jogador> findById(@PathVariable Long id) {
        return jogadorRepository.findById(id);
    }
}
