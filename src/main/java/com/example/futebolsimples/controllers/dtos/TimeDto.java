package com.example.futebolsimples.controllers.dtos;

import com.example.futebolsimples.entidades.Jogador;
import com.example.futebolsimples.entidades.Time;
import com.example.futebolsimples.repositorios.JogadorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TimeDto {

    private String nome;
    private List<Long> idJogadores = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public List<Long> getIdJogadores() {
        return idJogadores;
    }

    public Time toModel(JogadorRepository repository) {

        List<Jogador> jogadores = idJogadores.stream().map(jogador -> repository.findById(jogador).orElseThrow()).collect(Collectors.toList());

        return new Time(nome, jogadores);
    }


}
