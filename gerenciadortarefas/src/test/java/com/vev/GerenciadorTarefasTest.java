package com.vev;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

        assertEquals(novaSaida, "Tarefa: " + tarefa.toString() + "foi atualizada para" + novaTarefa.toString());    
    }

    @Test
    public void deletaTarefaTest() {
        Tarefa tarefa = new Tarefa("Comprar café", "Passar no mercado e comprar café São Braz", "12/02/2024", Prioridade.ALTA);
        gerenciadorTarefas.criaTarefa(tarefa);

        assertEquals(gerenciadorTarefas.tarefas.size(), 1);

        String novaSaida = gerenciadorTarefas.deletaTarefa(tarefa);

        assertEquals(novaSaida, "Tarefa" + tarefa.toString() + "foi deletada!");
        assertEquals(0, gerenciadorTarefas.tarefas.size());
    }    

    @Test
    public void listaTarefasTest(){
        Tarefa tarefa1 = new Tarefa("Estudar Java", "Preparar para a prova", "10/02/2023", Prioridade.ALTA);
        Tarefa tarefa2 = new Tarefa("Fazer exercícios", "Treino na academia", "08/01/2024", Prioridade.BAIXA);
        gerenciadorTarefas.criaTarefa(tarefa1);
        gerenciadorTarefas.criaTarefa(tarefa2);

        // Ordenada por prioridade e data de vencimento
        String tarefas = gerenciadorTarefas.listaTarefas();
        String tarefasEsperadas = "Título: Estudar Java \n Descrição: Preparar para a prova \n Data de vencimento:10/12/2023 \n Prioridade: Alta" +
                            "Título: Fazer exercícios \n Descrição: Treino na academia \n Data de vencimento:08/01/2024 \n Prioridade: Baixa";

        assertEquals(tarefas, tarefasEsperadas);
    }

}
