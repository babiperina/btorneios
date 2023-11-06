package com.example.score4you.controller;

import com.example.score4you.sport.Sport;
import com.example.score4you.sport.SportRepository;
import com.example.score4you.sport.SportRequestDTO;
import com.example.score4you.sport.SportResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sport")
public class sportController {

    @Autowired
    private SportRepository sportRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveSport(@RequestBody SportRequestDTO data){
        Sport sportData = new Sport(data);
        sportRepository.save(sportData);

        return;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<SportResponseDTO> getAll(){
        List<SportResponseDTO> matchesList = sportRepository.findAll().stream().map(SportResponseDTO::new).toList();

        return matchesList;
    }
}
