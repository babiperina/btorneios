package com.example.score4you.controller;

import com.example.score4you.genero.Genero;
import com.example.score4you.status.Status;
import com.example.score4you.status.StatusRepository;
import com.example.score4you.status.StatusRequestDTO;
import com.example.score4you.status.StatusResponseDTO;
import com.example.score4you.util.ResponseTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("status")
public class StatusController {

    @Autowired
    private StatusRepository statusRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseTransfer saveMatch(@RequestBody StatusRequestDTO data){
        Status statusData = new Status(data);
        statusRepository.save(statusData);
        return new ResponseTransfer(HttpStatus.OK,"Status cadastrado com sucesso.");
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<StatusResponseDTO> getAll(){
        List<StatusResponseDTO> status = statusRepository.findAll().stream().map(StatusResponseDTO::new).toList();
        return status;
    }
    @GetMapping("/{id}")
    public Optional<Status> findById(@PathVariable Long id) {
        return statusRepository.findById(id);
    }

}
