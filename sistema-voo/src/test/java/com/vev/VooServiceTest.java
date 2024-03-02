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

    @BeforeEach
    void setUp() {
        // inicializa vooService
        this.vs = new VooService();
        // adiciona voos
        try {
            vs.criaVoo("Campina Grande", "Recife", "12/02/2024", 200.0, 40);
            vs.criaVoo("São Paulo", "Rio de Janeiro", "29/12/2024", 150.5, 30);
            vs.criaVoo("Rio de Janeiro", "Recife", "10/07/2024", 300.0, 40);
            vs.criaVoo("Espírito Santo", "Porto Alegre", "01/06/2024", 320.9, 50);
            vs.criaVoo("Rio de Janeiro", "Manaus", "18/11/2024", 450.0, 45);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Test
    void testPesquisaVoo() {
        String origem = "Rio de Janeiro";
        String destino = "Recife";
        String data = "01/06/2024";
        int numPassageiros = 40;

        ArrayList<Voo> origemResultado = this.vs.pesquisaVoo(origem, null, null, 0);
        ArrayList<String> origemEsperado = new ArrayList<>(
            Arrays.asList("Rio de Janeiro-Recife-10/07/2024-40",
            "Rio de Janeiro-Manaus-18/11/2024-45"));

        ArrayList<Voo> destinoResultado = this.vs.pesquisaVoo(null, destino, null, 0);
        ArrayList<String> destinoEsperado = new ArrayList<>(
            Arrays.asList("Rio de Janeiro-Recife-10/07/2024-40",
            "Campina Grande-Recife-10/07/2024-40"));

        ArrayList<Voo> dataResultado = this.vs.pesquisaVoo(null, null, data, 0);
        ArrayList<String> dataEsperado = new ArrayList<>(
            Arrays.asList("Espírito Santo-Porto Alegre-01/06/2024-50"));

        ArrayList<Voo> numPassageirosResultado = this.vs.pesquisaVoo(null, null, null, numPassageiros);
        ArrayList<String> numPassageirosEsperado = new ArrayList<>(
            Arrays.asList("Rio de Janeiro-Recife-10/07/2024-40",
            "Campina Grande-Recife-10/07/2024-40"));

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
}
