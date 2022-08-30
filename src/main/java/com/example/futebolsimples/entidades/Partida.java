package com.example.futebolsimples.entidades;

import javax.persistence.*;

@Entity
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Time timeCasa;

    @OneToOne
    private Time timeRival;

    private int golsTimeCasa = 0;

    private int golsTimeRival = 0;

    private int cartaoAmareloTimeCasa = 0;

    private int cartaoAmareloTimeRival = 0;

    private int cartaoVermelhoTimeCasa = 0;

    private int cartaoVermelhoTimeRival = 0;

    private int penaltiTimeCasa = 0;

    private int penaltiTimeRival = 0;


    @Deprecated
    public Partida() {
    }

    public Partida(Time timeCasa, Time timeRival, int golsTimeCasa, int golsTimeRival, int cartaoAmareloTimeCasa, int cartaoAmareloTimeRival, int cartaoVermelhoTimeCasa, int cartaoVermelhoTimeRival, int penaltiTimeCasa, int penaltiTimeRival) {
        this.timeCasa = timeCasa;
        this.timeRival = timeRival;
        this.golsTimeCasa = golsTimeCasa;
        this.golsTimeRival = golsTimeRival;
        this.cartaoAmareloTimeCasa = cartaoAmareloTimeCasa;
        this.cartaoAmareloTimeRival = cartaoAmareloTimeRival;
        this.cartaoVermelhoTimeCasa = cartaoVermelhoTimeCasa;
        this.cartaoVermelhoTimeRival = cartaoVermelhoTimeRival;
        this.penaltiTimeCasa = penaltiTimeCasa;
        this.penaltiTimeRival = penaltiTimeRival;
    }

    public Time getTimeCasa() {
        return timeCasa;
    }

    public Time getTimeRival() {
        return timeRival;
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
