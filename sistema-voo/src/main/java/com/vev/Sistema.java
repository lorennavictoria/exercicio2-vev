package com.vev;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe principal do sistema de gerenciamento reservas de voos.
 *
 */
public class Sistema {

    private static UserService us;
    private static VooService vs;
    private static Util util;

    public static void main(String[] args) {

        us = new UserService();
        vs = new VooService();
        util = new Util();

        Scanner sc = new Scanner(System.in);

        System.out.println("BEM VINDO AO SISTEMA DE RESERVA DE VOOS!");
        System.out.println();

        try {
            vs.criaVoo("Campina Grande", "Recife", "12/02/2024", 200.0, 40, "09:00AM");
            vs.criaVoo("São Paulo", "Rio de Janeiro", "29/12/2024", 150.5, 30, "08:00PM");
            vs.criaVoo("Rio de Janeiro", "Recife", "10/07/2024", 300.0, 40, "06:30AM");
            vs.criaVoo("Espírito Santo", "Porto Alegre", "01/06/2024", 320.9, 50, "10:00PM");
            vs.criaVoo("Rio de Janeiro", "Manaus", "18/11/2024", 450.0, 45, "09:00AM");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        us.criaUser("Teste", "123", "123");

        String option = "";
        while (!option.equals("6")) {
            option = home(sc);

            switch (option) {
                case "1":
                    cadastroScreen(sc);
                    break;
                case "2":
                    listaScreen();
                    break;
                case "3":
                    pesquisaScreen(sc);
                    break;
                case "4":
                    reservaScreen(sc);
                    break;
                case "5":
                    cancelaReservaScreen(sc);
                    break;
            }
        }
    }

    private static String home(Scanner sc) {
        System.out.println("\u2554\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
        "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2557");
        System.out.println("\u2551                 Opções                  \u2551");
        System.out.println("\u2551                                         \u2551");
        System.out.println("\u2551  1. Cadastrar-se                        \u2551");
        System.out.println("\u2551  2. Listar Voos                         \u2551");
        System.out.println("\u2551  3. Pesquisa Voo                        \u2551");
        System.out.println("\u2551  4. Reservar Voos                       \u2551");
        System.out.println("\u2551  5. Cancelar Reserva                    \u2551");
        System.out.println("\u2551  6. Sair                                \u2551");
        System.out.println("\u2551                                         \u2551");
        System.out.println("\u255a\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
        "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u255d");
        System.out.print("Digite o número de sua opção desejada: ");

        String option = sc.next();
        return option;
    }

    private static void cadastroScreen(Scanner sc) {
        System.out.println("\u2554\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
        "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2557");
        System.out.println("\u2551         Digite suas informações         \u2551");
        System.out.println("\u2551                abaixo                   \u2551");
        System.out.println("\u255a\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
        "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u255d");

        sc.nextLine();
        System.out.print("\nNome: ");
        String nome = sc.nextLine();
        System.out.print("Telefone: ");
        String telefone = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        us.criaUser(nome, telefone, cpf);

        System.out.println("\u2554\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
        "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2557");
        System.out.println("\u2551        Usuário criado com sucesso!      \u2551");
        System.out.println("\u255a\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
        "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u255d");
    }

    private static void listaScreen() {
        ArrayList<String> voos = vs.listaVoos();

        for (String vooString : voos) {
            System.out.println(util.encapsulaDetailedToString(vooString));
        }

        System.out.println("\n");
    }

    private static void pesquisaScreen(Scanner sc) {
        System.out.println("\u2554\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
        "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2557");
        System.out.println("\u2551        Digite os termos que você quer pesquisar.    \u2551");
        System.out.println("\u2551 OBS: Deixar em branco significa ignorar o campo.)   \u2551");
        System.out.println("\u255a\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
        "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u255d");

        sc.nextLine();
        System.out.print("Origem: ");
        String origem = sc.nextLine();
        System.out.print("Destino: ");
        String destino = sc.nextLine();
        System.out.print("Data: ");
        String data = sc.nextLine();
        System.out.print("Lugares disponíveis: ");
        String lugaresDisponiveisString = sc.nextLine();


        int lugaresDisponiveis = 0;

        if (!lugaresDisponiveisString.equals("")) {
            lugaresDisponiveis = Integer.parseInt(lugaresDisponiveisString);
        }

        ArrayList<Voo> resultado = vs.pesquisaVoo(origem, destino, data, lugaresDisponiveis);

        if (resultado.isEmpty()) {
            System.out.println("Não existem vôos que correspondam a esta busca.");
        } else {
            for (Voo voo : resultado) {
                String detailedToString = voo.detailedToString();
                String encapsulada = util.encapsulaDetailedToString(detailedToString);
                System.out.println(encapsulada);
            }
        }

    }

    private static void reservaScreen(Scanner sc) {
        System.out.println("\u2554\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
        "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2557");
        System.out.println("\u2551        Digite o ID do voo a ser         \u2551");
        System.out.println("\u2551         reservado, seu CPF e a          \u2551");
        System.out.println("\u2551    quantidade de passageiros abaixo     \u2551");
        System.out.println("\u255a\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
        "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u255d");

        sc.nextLine();
        System.out.print("ID: ");
        String vooId = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        System.out.print("Passageiros: ");
        int passageiros = sc.nextInt();

        Reserva reserva = vs.reservaVoo(vooId, cpf, passageiros, us);
        String vooString = util.encapsulaConfirmacaoReserva(reserva);

        System.out.println("\u2554\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
        "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2557");
        System.out.println("\u2551         Reserva feita com sucesso!      \u2551");
        System.out.println("\u255a\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
        "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u255d");

        System.out.println(vooString);
    }

    private static void cancelaReservaScreen(Scanner sc) {
        System.out.println("\u2554\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
        "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2557");
        System.out.println("\u2551        Digite a seguir o código         \u2551");
        System.out.println("\u2551       da reserva a ser cancelada        \u2551");
        System.out.println("\u2551              e seu CPF.                 \u2551");
        System.out.println("\u255a\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
        "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u255d");

        sc.nextLine();
        System.out.print("Código da reserva: ");
        String reservaId = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        vs.cancelaReserva(cpf, reservaId);

        System.out.println("\u2554\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
        "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2557");
        System.out.println("\u2551       Reserva cancelada com sucesso!    \u2551");
        System.out.println("\u255a\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
        "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u255d");
    }
}
