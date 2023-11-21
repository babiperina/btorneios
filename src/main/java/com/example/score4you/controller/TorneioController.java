package com.example.score4you.controller;

import com.example.score4you.torneio.TorneioRequestDTO;
import com.example.score4you.torneio.TorneioResponseDTO;
import com.example.score4you.torneio.Torneio;
import com.example.score4you.torneio.TorneioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("torneio")
public class TorneioController {

    @Autowired
    private TorneioRepository torneioRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveMatch(@RequestBody TorneioRequestDTO data){
        Torneio torneioData = new Torneio(data);
        torneioRepository.save(torneioData);
        return;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<TorneioResponseDTO> getAll(){
        List<TorneioResponseDTO> torneios = torneioRepository.findAll().stream().map(TorneioResponseDTO::new).toList();
        return torneios;
    }
}
