package com.vev;

import java.util.ArrayList;

public class UserService {

    private ArrayList<User> users;

    public UserService() {
        this.users = new ArrayList<User>();
    }

    public User criaUser(String nome, String telefone, String cpf) throws Exception {

        if (telefone.length() != 11) {
            throw new Exception("Telefone deve conter 11 caracteres.");
        }

        if (cpf.length() != 11) {
            throw new Exception("CPF deve conter 11 caracteres.");
        }

        User newUser = new User(nome, telefone, cpf);

        users.add(newUser);
        
        return newUser;
    }

    public User getUserByCpf(String cpf) {
        for (User user : this.users) {
            if (cpf.equals(user.getCpf())) {
                return user;
            }
        } 

        return null;
    }
}