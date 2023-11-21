package com.example.score4you.controller;

import com.example.score4you.nivel.Nivel;
import com.example.score4you.nivel.NivelRepository;
import com.example.score4you.nivel.NivelRequestDTO;
import com.example.score4you.nivel.NivelResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("nivel")
public class NivelController {
    @Autowired
    private NivelRepository nivelRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveMatch(@RequestBody NivelRequestDTO data){
        Nivel nivelData = new Nivel(data);
        nivelRepository.save(nivelData);
        return;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<NivelResponseDTO> getAll(){
        List<NivelResponseDTO> niveis = nivelRepository.findAll().stream().map(NivelResponseDTO::new).toList();
        return niveis;
    }

    @GetMapping("/{id}")
    public Optional<Nivel> findById(@PathVariable Long id) {
        return nivelRepository.findById(id);
    }
}
