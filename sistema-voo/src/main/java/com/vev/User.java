package com.vev;

import java.util.ArrayList;

public class User {
    private String nome;
    private String telefone;
    private String cpf;
    private ArrayList<String> reservas;

    public User(String nome, String telefone, String cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.reservas = new ArrayList<String>();
    }

    public String getNome() {
        return this.nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String getCpf() {
        return this.cpf;
    }

    public ArrayList<String> getReservas() {
        return this.reservas;
    }

    public void adicionaReserva(Voo voo) {
        this.reservas.add(voo.getId());
    }
}
