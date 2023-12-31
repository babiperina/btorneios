package com.example.score4you.controller;


import com.example.score4you.dupla.Dupla;
import com.example.score4you.dupla.DuplaRepository;
import com.example.score4you.dupla.DuplaRequestDTO;
import com.example.score4you.dupla.DuplaResponseDTO;
import com.example.score4you.util.ResponseTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("dupla")
public class DuplaController {
    @Autowired
    private DuplaRepository duplaRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseTransfer saveMatch(@RequestBody DuplaRequestDTO data){
        Dupla duplaData = new Dupla(data);
        duplaRepository.save(duplaData);
        return new ResponseTransfer(HttpStatus.OK,"Dupla cadastrada com sucesso.");
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<DuplaResponseDTO> getAll(){
        List<DuplaResponseDTO> duplas = duplaRepository.findAll().stream().map(DuplaResponseDTO::new).toList();
        return duplas;
    }
    @GetMapping("/{id}")
    public Optional<Dupla> findById(@PathVariable Long id) {
        return duplaRepository.findById(id);
    }
}
