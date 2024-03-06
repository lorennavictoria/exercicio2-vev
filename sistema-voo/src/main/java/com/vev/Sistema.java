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
        } catch (Exception e) {
            e.printStackTrace();
        }

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
        String screen = "OPÇÕES:" + "\n\n"
        + "1. Cadastrar-se" + "\n"
        + "2. Listar Voos" + "\n"
        + "3. Pesquisa Voo" + "\n"
        + "4. Reservar Voo" + "\n"
        + "5. Cancelar Reserva" + "\n"
        + "6. Sair" + "\n";

        System.out.println(util.encapsulaString(screen, 50));
        System.out.print("Digite o número de sua opção desejada: ");

        String option = sc.next();
        return option;
    }

    private static void cadastroScreen(Scanner sc) {
        System.out.println("");
        String screen = "Digite suas informações abaixo.";
        System.out.println(util.encapsulaString(screen, 50));

        sc.nextLine();
        System.out.print("\nNome: ");
        String nome = sc.nextLine();
        System.out.print("Telefone: ");
        String telefone = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        try {
            us.criaUser(nome, telefone, cpf);

            String confirmation = "Usuário criado com sucesso!";
            System.out.println(util.encapsulaString(confirmation, 50));
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    private static void listaScreen() {
        ArrayList<String> voos = vs.listaVoos();

        for (String vooString : voos) {
            System.out.println(util.encapsulaString(vooString, 50));
        }

        System.out.println("\n");
    }

    private static void pesquisaScreen(Scanner sc) {
        System.out.println("");
        String screen = "Digite os termos que você pesquisar." + "\n"
        + "(deixar em branco significa ignorar campo)";
        System.out.println(util.encapsulaString(screen, 50));

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
                String encapsulada = util.encapsulaString(detailedToString, 42);
                System.out.println(encapsulada);
            }
        }

    }

    private static void reservaScreen(Scanner sc) {
        System.out.println("");
        String screen = "Digite o ID do voo a ser reservado," + "\n"
        + "seu CPF e a quantidade de passageiros:";
        System.out.println(util.encapsulaString(screen, 50));

        sc.nextLine();
        System.out.print("ID: ");
        String vooId = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        System.out.print("Passageiros: ");
        int passageiros = sc.nextInt();

        try {
            Reserva reserva = vs.reservaVoo(vooId, cpf, passageiros, us);
            String vooString = util.encapsulaString(reserva.toString(), 42);

            String confirmation = "Reserva feita com sucesso!";
            System.out.println(util.encapsulaString(confirmation, 50));

            System.out.println(vooString);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private static void cancelaReservaScreen(Scanner sc) {
        System.out.println("");
        String screen = "Digite a seguir o código de reserva" + "\n"
        + "a ser cancelada e seu CPF.";
        System.out.println(util.encapsulaString(screen, 50));

        sc.nextLine();
        System.out.print("Código da reserva: ");
        String reservaId = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        vs.cancelaReserva(cpf, reservaId);

        String confirmation = "Reserva cancelada com sucesso!";
        System.out.println(util.encapsulaString(confirmation, 50));
    }
}
