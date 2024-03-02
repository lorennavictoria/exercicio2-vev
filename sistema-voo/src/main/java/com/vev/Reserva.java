package com.vev;

public class Reserva {
    private double precoTotal;
    private User user;
    private Voo voo;
    private String id;
    private int passageiros;

    public Reserva(User user, Voo voo, int passageiros) {
        this.user = user;
        this.voo = voo;
        this.passageiros = passageiros;
        this.precoTotal = voo.getPreco() * passageiros;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public User getUser() {
        return user;
    }

    public Voo getVoo() {
        return voo;
    }

    public String getId() {
        return id;
    }

    public int getPassageiros() {
        return passageiros;
    }

}
