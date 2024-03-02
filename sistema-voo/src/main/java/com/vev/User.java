package com.vev;

public class User {
    private String nome;
    private String telefone;
    private String cpf;

    public User(String nome, String telefone, String cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
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
}
