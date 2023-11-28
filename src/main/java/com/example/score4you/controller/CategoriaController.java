package com.example.score4you.controller;

import com.example.score4you.categoria.Categoria;
import com.example.score4you.categoria.CategoriaRepository;
import com.example.score4you.categoria.CategoriaRequestDTO;
import com.example.score4you.categoria.CategoriaResponseDTO;
import com.example.score4you.util.ResponseTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("categoria")
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseTransfer saveMatch(@RequestBody CategoriaRequestDTO data){
        Categoria categoriaData = new Categoria(data);
        categoriaRepository.save(categoriaData);
        return new ResponseTransfer(HttpStatus.OK,"Categoria cadastrada com sucesso.");
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<CategoriaResponseDTO> getAll(){
        List<CategoriaResponseDTO> categorias = categoriaRepository.findAll().stream().map(CategoriaResponseDTO::new).toList();
        return categorias;
    }
    @GetMapping("/{id}")
    public Optional<Categoria> findById(@PathVariable Long id) {
        return categoriaRepository.findById(id);
    }
}
