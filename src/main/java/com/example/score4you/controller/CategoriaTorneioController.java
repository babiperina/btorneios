package com.example.score4you.controller;

import com.example.score4you.categoriaTorneio.CategoriaTorneio;
import com.example.score4you.categoriaTorneio.CategoriaTorneioRepository;
import com.example.score4you.categoriaTorneio.CategoriaTorneioRequestDTO;
import com.example.score4you.categoriaTorneio.CategoriaTorneioResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categoria_torneio")
public class CategoriaTorneioController {
    @Autowired
    private CategoriaTorneioRepository categoriaTorneioRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveMatch(@RequestBody CategoriaTorneioRequestDTO data) {
        CategoriaTorneio categoriaTorneioData = new CategoriaTorneio(data);
        categoriaTorneioRepository.save(categoriaTorneioData);
        return;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<CategoriaTorneioResponseDTO> getAll() {
        List<CategoriaTorneioResponseDTO> categoriasTorneios = categoriaTorneioRepository.findAll().stream().map(CategoriaTorneioResponseDTO::new).toList();
        return categoriasTorneios;
    }

}