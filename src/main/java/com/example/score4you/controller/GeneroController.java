package com.example.score4you.controller;

import com.example.score4you.genero.Genero;
import com.example.score4you.genero.GeneroRepository;
import com.example.score4you.genero.GeneroRequestDTO;
import com.example.score4you.genero.GeneroResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("genero")
public class GeneroController {

    @Autowired
    private GeneroRepository generoRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveMatch(@RequestBody GeneroRequestDTO data){
        Genero generoData = new Genero(data);
        generoRepository.save(generoData);
        return;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<GeneroResponseDTO> getAll(){
        List<GeneroResponseDTO> generos = generoRepository.findAll().stream().map(GeneroResponseDTO::new).toList();
        return generos;
    }
    @GetMapping("/{id}")
    public Optional<Genero> findById(@PathVariable Long id) {
        return generoRepository.findById(id);
    }

}
