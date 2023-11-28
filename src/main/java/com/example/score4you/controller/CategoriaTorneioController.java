package com.example.score4you.controller;

import com.example.score4you.categoriaTorneio.CategoriaTorneio;
import com.example.score4you.categoriaTorneio.CategoriaTorneioRepository;
import com.example.score4you.categoriaTorneio.CategoriaTorneioRequestDTO;
import com.example.score4you.categoriaTorneio.CategoriaTorneioResponseDTO;
import com.example.score4you.util.ResponseTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categoria_torneio")
public class CategoriaTorneioController {
    @Autowired
    private CategoriaTorneioRepository categoriaTorneioRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseTransfer saveMatch(@RequestBody CategoriaTorneioRequestDTO data) {
        CategoriaTorneio categoriaTorneioData = new CategoriaTorneio(data);
        categoriaTorneioRepository.save(categoriaTorneioData);
        return new ResponseTransfer(HttpStatus.OK,"Categoria associada ao Torneio com sucesso.");
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<CategoriaTorneioResponseDTO> getAll() {
        List<CategoriaTorneioResponseDTO> categoriasTorneios = categoriaTorneioRepository.findAll().stream().map(CategoriaTorneioResponseDTO::new).toList();
        return categoriasTorneios;
    }

}