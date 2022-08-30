package com.example.futebolsimples.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private int golsMarcados = 0;

    @Deprecated
    public Jogador(){}

    public Jogador(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getGolsMarcados() {
        return golsMarcados;
    }

    public void adicionaGols(int gols) {
        this.golsMarcados += gols;
    }
}
