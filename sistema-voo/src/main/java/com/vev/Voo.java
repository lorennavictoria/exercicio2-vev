package com.vev;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class Voo {
    private String origem;
    private String destino;
    private Date date;
    private double preco;
    private int lugares;
    private int passageiros;
    private LocalTime horario;


    public Voo(String origem, String destino, Date date, double preco, int lugares, LocalTime horario) {
        this.origem = origem;
        this.destino = destino;
        this.date = date;
        this.preco = preco;
        this.lugares = lugares;
        this.passageiros = 0;
        this.horario = horario;
    }

    public String getOrigem() {
        return this.origem;
    }


    public String getDestino() {
        return this.destino;
    }


    public Date getDate() {
        return this.date;
    }


    public double getPreco() {
        return this.preco;
    }

    public String getHorario() {
        return this.horario.toString();
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }


    public int getLugaresLivres() {
        return this.lugares - this.passageiros;
    }

    public void addPassageiros(int newPassgeiros) {
        if ((this.lugares - this.passageiros) > newPassgeiros) {
            this.passageiros += newPassgeiros;
        }
    }
    
    public String toString() {
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        String dateString = fmt.format(date);
        return this.origem + "-" + this.destino + "-" + dateString + "-" + this.lugares;
    }

}