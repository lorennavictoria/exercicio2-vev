package com.vev;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserServiceTest {
    private UserService us;

    @BeforeEach
    void setUp() {
        this.us = new UserService();
    }

    @Test
    void testCriaUser() {
        String nome = "Usuário Teste";
        String telefone = "82988887777";
        String cpf = "44455566677";

        us.criaUser(nome, telefone, cpf);

        User user = this.us.getUserByCpf(cpf);

        assertEquals(user.getNome(), nome);
        assertEquals(user.getTelefone(), telefone);
        assertEquals(user.getCpf(), cpf);
    }
}
