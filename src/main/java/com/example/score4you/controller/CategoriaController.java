package com.example.score4you.controller;

import com.example.score4you.categoria.Categoria;
import com.example.score4you.categoria.CategoriaRepository;
import com.example.score4you.categoria.CategoriaRequestDTO;
import com.example.score4you.categoria.CategoriaResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("categoria")
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveMatch(@RequestBody CategoriaRequestDTO data){
        Categoria categoriaData = new Categoria(data);
        categoriaRepository.save(categoriaData);
        return;
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
