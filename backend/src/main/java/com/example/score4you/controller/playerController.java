package com.example.score4you.controller;

import com.example.score4you.player.PlayerRequestDTO;
import com.example.score4you.player.PlayerResponseDTO;
import com.example.score4you.player.Player;
import com.example.score4you.player.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("player")
public class playerController {

    @Autowired
    private PlayerRepository playerRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void savePlayer(@RequestBody PlayerRequestDTO data){
        Player playerData = new Player(data);
        playerRepository.save(playerData);
        return;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<PlayerResponseDTO> getAll(){
        List<PlayerResponseDTO> playerList = playerRepository.findAll().stream().map(PlayerResponseDTO::new).toList();

        return playerList;
    }
}

