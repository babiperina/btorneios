package com.example.score4you.controller;

import com.example.score4you.matches.MatchRequestDTO;
import com.example.score4you.matches.MatchResponseDTO;
import com.example.score4you.matches.Matches;
import com.example.score4you.matches.MatchesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("matches")
public class mainController {

    @Autowired
    private MatchesRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveMatch(@RequestBody MatchRequestDTO data){
        Matches matchData = new Matches(data);
        repository.save(matchData);
        return;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<MatchResponseDTO> getAll(){
        List<MatchResponseDTO> matchesList = repository.findAll().stream().map(MatchResponseDTO::new).toList();

        return matchesList;
    }
}
