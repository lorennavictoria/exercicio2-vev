package com.vev;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Teste de unidade para VooService.
 */
public class VooServiceTest {

    // inclui vooService como atributo
    private VooService vs;
    private UserService us;

    @BeforeEach
    void setUp() {
        // inicializa vooService
        this.vs = new VooService();
        this.us = new UserService();

        // adiciona voos
        try {
            vs.criaVoo("Campina Grande", "Recife", "12/02/2024", 200.0, 40, "09:00AM");
            vs.criaVoo("São Paulo", "Rio de Janeiro", "29/12/2024", 150.5, 30, "08:00PM");
            vs.criaVoo("Rio de Janeiro", "Recife", "10/07/2024", 300.0, 40, "06:30AM");
            vs.criaVoo("Espírito Santo", "Porto Alegre", "01/06/2024", 320.9, 50, "10:00PM");
            vs.criaVoo("Rio de Janeiro", "Manaus", "18/11/2024", 450.0, 45, "09:00AM");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        us.criaUser("José Amêncio", "8396544-0988", "12312312312");
        us.criaUser("Júlia Guerra", "8198765-1234", "88877766643");
        us.criaUser("Pedro Borges", "8799988-8282", "75675675677");
        us.criaUser("Maria Sílvia", "2196655-4432", "12345678910");

    }

    @Test
    void testCriaVoo() {
        String origem = "OrigemTeste";
        String destino = "DestinoTeste";
        String data = "02/03/1993";
        double preco  = 39.4;
        int lugares = 20;
        String horario = "03:20PM";

        Voo newVoo;

        try {
            newVoo = this.vs.criaVoo(origem, destino, data, preco, lugares, horario);

            assertEquals(newVoo.getOrigem(), origem);
            assertEquals(newVoo.getDestino(), destino);
            assertEquals(newVoo.getDateString(), data);
            assertEquals(newVoo.getPreco(), preco);
            assertEquals(newVoo.getLugaresLivres(), lugares);
            assertEquals(newVoo.getHorario(), "15:20");

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testPesquisaVoo() {
        String origem = "Rio de Janeiro";
        String destino = "Recife";
        String data = "01/06/2024";
        int numPassageiros = 41;

        ArrayList<Voo> origemResultado = this.vs.pesquisaVoo(origem, null, null, 0);
        ArrayList<String> origemEsperado = new ArrayList<>(
            Arrays.asList("Rio de Janeiro-Recife-10/07/2024-40",
            "Rio de Janeiro-Manaus-18/11/2024-45"));

        ArrayList<Voo> destinoResultado = this.vs.pesquisaVoo(null, destino, null, 0);
        ArrayList<String> destinoEsperado = new ArrayList<>(
            Arrays.asList("Rio de Janeiro-Recife-10/07/2024-40",
            "Campina Grande-Recife-12/02/2024-40"));

        ArrayList<Voo> dataResultado = this.vs.pesquisaVoo(null, null, data, 0);
        ArrayList<String> dataEsperado = new ArrayList<>(
            Arrays.asList("Espírito Santo-Porto Alegre-01/06/2024-50"));

        ArrayList<Voo> numPassageirosResultado = this.vs.pesquisaVoo(null, null, null, numPassageiros);
        ArrayList<String> numPassageirosEsperado = new ArrayList<>(
            Arrays.asList("Espírito Santo-Porto Alegre-01/06/2024-50",
            "Rio de Janeiro-Manaus-18/11/2024-45"));

        for (Voo voo : origemResultado) { 
            assertTrue(origemEsperado.contains(voo.toString()));
        }

        for (Voo voo : destinoResultado) { 
            assertTrue(destinoEsperado.contains(voo.toString()));
        }

        for (Voo voo : dataResultado) { 
            assertTrue(dataEsperado.contains(voo.toString()));
        }

        for (Voo voo : numPassageirosResultado) { 
            assertTrue(numPassageirosEsperado.contains(voo.toString()));
        }
    }

    @Test
    void testListaVoo() {
        ArrayList<String> voosListados = vs.listaVoos();

        String voo1 = "Origem: Campina Grande\nDestino: Recife\nHorário: 09:00\nPreço: R$200.0\nLugares Disponíveis: 40";
        String voo2 = "Origem: Espírito Santo\nDestino: Porto Alegre\nHorário: 22:00\nPreço: R$320.9\nLugares Disponíveis: 50";

        assertTrue(voosListados.contains(voo1));
        assertTrue(voosListados.contains(voo2));
    }

    @Test
    void testReservaVoo() {
        ArrayList<Voo> voos = this.vs.pesquisaVoo(null, null, null, 0);
        User user = this.us.getUserByCpf("12312312312");

        Voo vooReserva = voos.get(1);
        int lugaresLivresTemp = vooReserva.getLugaresLivres();
        int passageiros = 2;

        Reserva reserva = vs.reservaVoo(vooReserva.getId(), user.getCpf(), passageiros, this.us);

        assertEquals(lugaresLivresTemp - 2, vooReserva.getLugaresLivres());
        assertEquals(reserva.getPrecoTotal(), passageiros * vooReserva.getPreco());
        assertTrue(this.vs.getReservas(user.getCpf()).contains(reserva));
    }

    @Test
    void testCancelaReserva() {
        ArrayList<Voo> voos = this.vs.pesquisaVoo(null, null, null, 0);
        User user = this.us.getUserByCpf("12312312312");

        Voo vooReserva = voos.get(1);
        int passageiros = 2;

        Reserva reserva = vs.reservaVoo(vooReserva.getId(), user.getCpf(), passageiros, this.us);

        int reservasSizeTemp = this.vs.getReservas(user.getCpf()).size();

        this.vs.cancelaReserva(user.getCpf(), reserva.getId());

        assertFalse(this.vs.getReservas(user.getCpf()).contains(reserva));
        assertEquals(reservasSizeTemp - 1, this.vs.getReservas(user.getCpf()).size());

    }
}
