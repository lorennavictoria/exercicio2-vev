package com.vev;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

public class GerenciadorTarefasTest {
    
    GerenciadorTarefas gerenciadorTarefas = new GerenciadorTarefas();

    @Test
    public void CriaTarefaTeste(){
        Tarefa tarefa = new Tarefa("Comprar café", "Passar no mercado na volta e comprar café", "12/02/2024", Prioridade.ALTA);
        String saida = gerenciadorTarefas.criaTarefa(tarefa);

        assertEquals(saida, "Tarefa criada com sucesso!");
    }

    @Test
    public void atualizaTarefaTeste() {
        Tarefa tarefa = new Tarefa("Comprar café", "Passar no mercado na volta e comprar café", "12/02/2024", Prioridade.ALTA);
        gerenciadorTarefas.criaTarefa(tarefa);

        Tarefa novaTarefa = new Tarefa("Comprar café", "Pedir por delivery", "12/02/2024", Prioridade.ALTA);
        String novaSaida = gerenciadorTarefas.atualizaTarefa(tarefa, novaTarefa);

        assertEquals(novaSaida, "Tarefa: xxx foi atualizada para yyy");   
    }


}
