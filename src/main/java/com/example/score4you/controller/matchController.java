package com.example.score4you.controller;

import com.example.score4you.match.MatchRequestDTO;
import com.example.score4you.match.MatchResponseDTO;
import com.example.score4you.match.Match;
import com.example.score4you.match.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("match")
public class matchController {

    @Autowired
    private MatchRepository matchRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveMatch(@RequestBody MatchRequestDTO data){
        Match matchData = new Match(data);
        matchRepository.save(matchData);
        return;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<MatchResponseDTO> getAll(){
        List<MatchResponseDTO> matchesList = matchRepository.findAll().stream().map(MatchResponseDTO::new).toList();

        return matchesList;
    }
}
