package com.example.futebolsimples.controllers;

import com.example.futebolsimples.controllers.dtos.PartidaDto;
import com.example.futebolsimples.entidades.Partida;
import com.example.futebolsimples.repositorios.JogadorRepository;
import com.example.futebolsimples.repositorios.PartidaRepository;
import com.example.futebolsimples.repositorios.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/partidas")
public class PartidaController {

    @Autowired
    private PartidaRepository repository;

    @Autowired
    private TimeRepository timeRepository;

    @Autowired
    private JogadorRepository jogadorRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastraPartida(@RequestBody PartidaDto partidaDto) {
        Partida partida = partidaDto.toModel(timeRepository);

        repository.save(partida);
        distribuiGols(partida);
    }

    @GetMapping
    public ResponseEntity<List<Partida>> findAllPartidas() {
        List<Partida> partidas = repository.findAll();

        return ResponseEntity.ok().body(partidas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partida> findPartidaPorId(@PathVariable Long id) {

        Optional<Partida> partida = repository.findById(id);

        if (partida.isPresent()) {
            return ResponseEntity.ok().body(partida.get());
        }

        return ResponseEntity.notFound().build();
    }

    private void distribuiGols(Partida partida) {

        Random random = new Random();

        int golsTimeCasa = partida.getGolsTimeCasa();

        while (golsTimeCasa > 0) {

            partida.getTimeCasa().getJogadores()
                    .get(random.nextInt(partida.getTimeCasa().getJogadores().size()))
                    .adicionaGols(1);

            golsTimeCasa--;
        }

        int golsTimeRival = partida.getGolsTimeRival();

        while (golsTimeRival > 0) {

            partida.getTimeRival().getJogadores()
                    .get(random.nextInt(partida.getTimeRival().getJogadores().size()))
                    .adicionaGols(1);

            golsTimeRival--;
        }

        jogadorRepository.saveAll(partida.getTimeCasa().getJogadores());
        jogadorRepository.saveAll(partida.getTimeRival().getJogadores());
    }
}
