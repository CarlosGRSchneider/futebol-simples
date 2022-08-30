package com.example.futebolsimples.controllers;

import com.example.futebolsimples.controllers.dtos.TimeDto;
import com.example.futebolsimples.entidades.Time;
import com.example.futebolsimples.repositorios.JogadorRepository;
import com.example.futebolsimples.repositorios.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/times")
public class TimeController {

    @Autowired
    private TimeRepository repository;

    @Autowired
    private JogadorRepository jogadorRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastraTime(@RequestBody TimeDto timeDto) {

        Time time = timeDto.toModel(jogadorRepository);
        System.out.println(time.getNome());
        System.out.println(time.getId());

        repository.save(time);
    }

    @GetMapping
    public ResponseEntity<List<Time>> findAll() {

        List<Time> times = repository.findAll();

        return ResponseEntity.ok().body(times);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Time> findTimeById(@PathVariable Long id) {

        Optional<Time> time = repository.findById(id);

        if (time.isPresent()) {
            return ResponseEntity.ok().body(time.get());
        }
        return ResponseEntity.notFound().build();
    }
}
