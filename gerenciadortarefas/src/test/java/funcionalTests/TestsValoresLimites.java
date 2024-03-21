package funcionalTests;

import com.vev.GerenciadorTarefas;
import com.vev.Prioridade;
import com.vev.Tarefa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;

public class TestsValoresLimites {
    
    GerenciadorTarefas gerenciadorTarefas = new GerenciadorTarefas();

    @Test
    public void ExibirTaredasListaComTarefas(){
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

    @Test
    public void ExibirTaredasListaComApenasUmaTarefa(){
        Tarefa tarefa = new Tarefa("Estudar Java", "Preparar para a prova", "10/02/2023", Prioridade.ALTA);
        
        gerenciadorTarefas.criaTarefa(tarefa);

        // Ordenada por prioridade e data de vencimento
        String tarefas = gerenciadorTarefas.listaTarefas();
        String tarefasEsperadas = "\n Título: Estudar Java \n Descrição: Preparar para a prova \n Data de vencimento:2023-02-10 \n Prioridade: ALTA";
                            
        assertEquals(tarefas, tarefasEsperadas);
    }

    @Test
    public void ExibirTaredasListaSemTarefas(){
        String tarefas = gerenciadorTarefas.listaTarefas();
        String tarefasEsperadas = "";

        assertEquals(tarefas, tarefasEsperadas);
    }

}