package com.vev;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class VooService {

    private ArrayList<Voo> voos;
    private SimpleDateFormat df;

    public VooService() {
        this.voos = new ArrayList<Voo>();
        this.df = new SimpleDateFormat("dd/MM/yyyy");
    }

    public Voo criaVoo(String origem, String destino, String date, double preco, int lugares, String horario) throws ParseException {

        Date realDate;
        LocalTime realHorario;

        try {
            realDate = df.parse(date);
            realHorario = LocalTime.parse(horario, DateTimeFormatter.ofPattern("hh:mma"));
        } catch (ParseException e) {
            throw e;
        }

        Voo newVoo = new Voo(origem, destino, realDate, preco, lugares, realHorario);
        this.voos.add(newVoo);
        return newVoo;

    }

    public ArrayList<Voo> pesquisaVoo(String origem, String destino, String date, int lugares) {
        ArrayList<Voo> resultado = new ArrayList<Voo>();

        for (Voo voo : this.voos) {
            if ((origem == null || origem.equals(voo.getOrigem())) &&
            (destino == null || destino.equals(voo.getDestino())) &&
            (date == null || date.equals(voo.getDate().toString())) &&
            (lugares == 0 || voo.getLugaresLivres() >= lugares)) {
                resultado.add(voo);
            }
        }

        return resultado;
    }

    public ArrayList<String> listaVoos() {
        ArrayList<String> listaDetalhada = new ArrayList<>();

        for (Voo voo : this.voos) {
            String finalString = "Origem: " + voo.getOrigem() + "\n" + "Destino: "
            + voo.getDestino() + "\n" + "Horário: " + voo.getHorario() 
            + "\n" + "Preço: R$" + voo.getPreco() + "\n" 
            + "Lugares Disponíveis: " + voo.getLugaresLivres();

            listaDetalhada.add(finalString);
        }

        return listaDetalhada;

    }

    /**
     * Reserva voo em nome do usuário com CPF fornecido.
     * 
     * @param vooId id do voo
     * @param cpf cpf do usuário
     * @param passageiros quantidade de passageiros em reserva
     * @param us UserService para controle de usuário
     * 
     * @return preço total se reserva tiver sucesso, 0 caso contrário.
     */
    public double reservaVoo(String vooId, String cpf, int passageiros, UserService us) {
        Voo vooReserva = this.getVooById(vooId);

        if (passageiros < vooReserva.getLugaresLivres()) {
            vooReserva.addPassageiros(passageiros);
            us.adicionaReservaByCpf(cpf, vooReserva);
            double precoTotal = passageiros * vooReserva.getPreco();
            return precoTotal;
        }

        return 0;
    }

    private Voo getVooById(String id) {
        for (Voo voo : this.voos) {
            if (id.equals(voo.getId())) {
                return voo;
            }
        } 

        return null;
    }
}
