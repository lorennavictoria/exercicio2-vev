package com.vev;

public class Reserva {
    private double precoTotal;
    private User user;
    private Voo voo;
    private String id;
    private int passageiros;

    public Reserva(User user, Voo voo, int passageiros) {
        Util util = new Util();

        this.user = user;
        this.voo = voo;
        this.passageiros = passageiros;
        this.precoTotal = voo.getPreco() * passageiros;
        this.id = util.generateId(6);
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

    public String toString() {
        String finalString = "VOO RESERVADO:" + "\n\n" + "Origem: " + this.voo.getOrigem() + "\n" + "Destino: "
        + this.voo.getDestino() + "\n" + "Horário: " + this.voo.getHorario()
        + "\n" + "Preço: R$" + this.voo.getPreco() + "\n" 
        + "Lugares Disponíveis: " + this.voo.getLugaresLivres() + "\n\n" + "Passageiros: " 
        + this.passageiros + "\n" + "TOTAL: R$" + this.precoTotal + "\n" + "Código: " + this.id;

        return finalString;
    }

}
