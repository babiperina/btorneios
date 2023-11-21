package com.example.score4you.controller;


import com.example.score4you.dupla.Dupla;
import com.example.score4you.dupla.DuplaRepository;
import com.example.score4you.dupla.DuplaRequestDTO;
import com.example.score4you.dupla.DuplaResponseDTO;
import com.example.score4you.duplaTorneio.DuplaTorneio;
import com.example.score4you.duplaTorneio.DuplaTorneioRepository;
import com.example.score4you.duplaTorneio.DuplaTorneioRequestDTO;
import com.example.score4you.duplaTorneio.DuplaTorneioResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("dupla_torneio")
public class DuplaTorneioController {
    @Autowired
    private DuplaTorneioRepository duplaTorneioRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveMatch(@RequestBody DuplaTorneioRequestDTO data){
        DuplaTorneio duplaTorneioData = new DuplaTorneio(data);
        duplaTorneioRepository.save(duplaTorneioData);
        return;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<DuplaTorneioResponseDTO> getAll(){
        List<DuplaTorneioResponseDTO> duplasTorneios = duplaTorneioRepository.findAll().stream().map(DuplaTorneioResponseDTO::new).toList();
        return duplasTorneios;
    }
    @GetMapping("/{id}")
    public Optional<DuplaTorneio> findById(@PathVariable Long id) {
        return duplaTorneioRepository.findById(id);
    }
}
