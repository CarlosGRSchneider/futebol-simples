package com.example.futebolsimples.controllers.dtos;


import com.example.futebolsimples.entidades.Jogador;

public class JogadorDto {

    private String nome;

    public String getNome() {
        return nome;
    }

    public Jogador toModel() {
        return new Jogador(nome);
    }
}
