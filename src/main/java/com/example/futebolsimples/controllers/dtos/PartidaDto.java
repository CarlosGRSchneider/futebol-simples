package com.example.futebolsimples.controllers.dtos;

import com.example.futebolsimples.entidades.Partida;
import com.example.futebolsimples.entidades.Time;
import com.example.futebolsimples.repositorios.TimeRepository;

public class PartidaDto {

    private long idTimeCasa;

    private long idTimeRival;

    private int golsTimeCasa;

    private int golsTimeRival;

    private int cartaoAmareloTimeCasa;

    private int cartaoAmareloTimeRival;

    private int cartaoVermelhoTimeCasa;

    private int cartaoVermelhoTimeRival;

    private int penaltiTimeCasa;

    private int penaltiTimeRival;

    public Partida toModel(TimeRepository repository) {
        Time timeCasa = repository.findById(idTimeCasa).orElseThrow();
        Time timeRival = repository.findById(idTimeRival).orElseThrow();

        return new Partida(timeCasa, timeRival, golsTimeCasa, golsTimeRival, cartaoAmareloTimeCasa, cartaoAmareloTimeRival, cartaoVermelhoTimeCasa, cartaoVermelhoTimeRival, penaltiTimeCasa, penaltiTimeRival);
    }

    public long getIdTimeCasa() {
        return idTimeCasa;
    }

    public long getIdTimeRival() {
        return idTimeRival;
    }

    public int getGolsTimeCasa() {
        return golsTimeCasa;
    }

    public int getGolsTimeRival() {
        return golsTimeRival;
    }

    public int getCartaoAmareloTimeCasa() {
        return cartaoAmareloTimeCasa;
    }

    public int getCartaoAmareloTimeRival() {
        return cartaoAmareloTimeRival;
    }

    public int getCartaoVermelhoTimeCasa() {
        return cartaoVermelhoTimeCasa;
    }

    public int getCartaoVermelhoTimeRival() {
        return cartaoVermelhoTimeRival;
    }

    public int getPenaltiTimeCasa() {
        return penaltiTimeCasa;
    }

    public int getPenaltiTimeRival() {
        return penaltiTimeRival;
    }
}
