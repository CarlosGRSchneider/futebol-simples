package com.example.futebolsimples.controllers;

import com.example.futebolsimples.controllers.dtos.JogadorDto;
import com.example.futebolsimples.entidades.Jogador;
import com.example.futebolsimples.repositorios.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    @Autowired
    private JogadorRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionaJogador(@RequestBody JogadorDto jogadorDto) {

        Jogador jogador = jogadorDto.toModel();

        repository.save(jogador);

    }

    @GetMapping
    public ResponseEntity<List<Jogador>> findAll() {
        List<Jogador> jogadores = repository.findAll();

        return ResponseEntity.ok().body(jogadores);
    }

    @GetMapping("/{id}/id")
    public ResponseEntity<Jogador> findJogadorById(@PathVariable Long id) {
        Optional<Jogador> jogador = repository.findById(id);

        if (jogador.isPresent()) {
            return ResponseEntity.ok().body(jogador.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{nome}/nome")
    public ResponseEntity<Jogador> findJogadorByNome(@PathVariable String nome) {
        Optional<Jogador> jogador = repository.findByNome(nome);

        if (jogador.isPresent()) {
            return ResponseEntity.ok().body(jogador.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/estatisticas")
    public ResponseEntity<List<Jogador>> getEstatisticasDeGol() {

        List<Jogador> jogadores = repository.findByGolsMarcadosDesc();

        return ResponseEntity.ok().body(jogadores);
    }
}
