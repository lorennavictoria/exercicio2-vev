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

        assertEquals(novaSaida, "Tarefa: \n" + tarefa.toString() + "\n Foi atualizada para: \n" + novaTarefa.toString());    
    }

    @Test
    public void deletaTarefaTest() {
        Tarefa tarefa = new Tarefa("Comprar café", "Passar no mercado e comprar café São Braz", "12/02/2024", Prioridade.ALTA);
        gerenciadorTarefas.criaTarefa(tarefa);

        assertEquals(gerenciadorTarefas.tarefas.contains(tarefa), true);

        String novaSaida = gerenciadorTarefas.deletaTarefa(tarefa);

        assertEquals(novaSaida, "Tarefa: \n" + tarefa.toString() + "\n foi deletada!");
        assertEquals(gerenciadorTarefas.tarefas.contains(tarefa), false);
    }    

    @Test
    public void listaTarefasTest(){
        Tarefa tarefa1 = new Tarefa("Estudar Java", "Preparar para a prova", "10/02/2023", Prioridade.ALTA);
        Tarefa tarefa2 = new Tarefa("Fazer exercícios", "Treino na academia", "08/01/2024", Prioridade.BAIXA);
        gerenciadorTarefas.criaTarefa(tarefa1);
        gerenciadorTarefas.criaTarefa(tarefa2);

        // Ordenada por prioridade e data de vencimento
        String tarefas = gerenciadorTarefas.listaTarefas();
        String tarefasEsperadas = "\n Título: Estudar Java \n Descrição: Preparar para a prova \n Data de vencimento:2023-02-10 \n Prioridade: ALTA" +
                            "\n Título: Fazer exercícios \n Descrição: Treino na academia \n Data de vencimento:2024-01-08 \n Prioridade: BAIXA";

        assertEquals(tarefas, tarefasEsperadas);
    }

}
