package funcionalTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.format.DateTimeParseException;

import org.junit.jupiter.api.Test;

import com.vev.GerenciadorTarefas;
import com.vev.Prioridade;
import com.vev.Tarefa;

public class TestsTabelasDecisao {
    
    GerenciadorTarefas gerenciadorTarefas = new GerenciadorTarefas();

    @Test
    public void Regra1CriacaoTarefa() {
        Tarefa tarefa = new Tarefa("Comprar café", "Passar no mercado na volta e comprar café", "21/03/2024", Prioridade.ALTA);
        String saida = gerenciadorTarefas.criaTarefa(tarefa);
        assertEquals(saida, "Tarefa criada com sucesso!");
    }

    @Test
    public void Regra2CriacaoTarefa() {
        assertThrows(NullPointerException.class, () -> { 
            Tarefa tarefa = new Tarefa("", "Passar no mercado na volta e comprar café", "21/03/2024", Prioridade.ALTA);
            String saida = gerenciadorTarefas.criaTarefa(tarefa);
        });
    }

    @Test
    public void Regra3CriacaoTarefa() {
        assertThrows(NullPointerException.class, () -> { 
            Tarefa tarefa = new Tarefa("Comprar Café", "", "21/03/2024", Prioridade.ALTA);
            String saida = gerenciadorTarefas.criaTarefa(tarefa);
        });
    }

    @Test
    public void Regra4CriacaoTarefa() {
        assertThrows(DateTimeParseException.class, () -> { 
            Tarefa tarefa = new Tarefa("Comprar Café", "Comprar café no mercado da esquina", "", Prioridade.ALTA);
            String saida = gerenciadorTarefas.criaTarefa(tarefa);
        });
    }

    @Test
    public void Regra5CriacaoTarefa() {
        assertThrows(NullPointerException.class, () -> { 
            Tarefa tarefa = new Tarefa("Comprar Café", "Comprar café no mercado da esquina", "21/03/2024", null);
            String saida = gerenciadorTarefas.criaTarefa(tarefa);
        });
    }

    @Test
    public void Regra1AtualizarTarefa() {
        Tarefa tarefa = new Tarefa("Comprar Café", "Comprar café no mercado da esquina", "21/03/2024", Prioridade.ALTA);
        gerenciadorTarefas.criaTarefa(tarefa);
        
        Tarefa novaTarefa = new Tarefa("Comprar Chá", "Comprar chá no mercado da esquina", "22/03/2024", Prioridade.BAIXA);
        String atualizacao = gerenciadorTarefas.atualizaTarefa(tarefa, novaTarefa);
        assertEquals(atualizacao, "Tarefa: \n" + tarefa.toString() + "\n Foi atualizada para: \n" + novaTarefa.toString());    
    }

    @Test
    public void Regra2AtualizarTarefa() {
        assertThrows(NullPointerException.class, () -> { 
            Tarefa tarefa = new Tarefa("Comprar Café", "Comprar café no mercado da esquina", "21/03/2024", Prioridade.ALTA);
            gerenciadorTarefas.criaTarefa(tarefa);
            
            Tarefa novaTarefa = new Tarefa("", "Comprar café no mercado da esquina", "21/03/2024", Prioridade.ALTA);
            String atualizacao = gerenciadorTarefas.atualizaTarefa(tarefa, novaTarefa);
        });
    }

    @Test
    public void Regra3AtualizarTarefa() {
        assertThrows(NullPointerException.class, () -> { 
            Tarefa tarefa = new Tarefa("Comprar Café", "Comprar café no mercado da esquina", "21/03/2024", Prioridade.ALTA);
            gerenciadorTarefas.criaTarefa(tarefa);
            
            Tarefa novaTarefa = new Tarefa("Comprar Café", "", "21/03/2024", Prioridade.ALTA);
            String atualizacao = gerenciadorTarefas.atualizaTarefa(tarefa, novaTarefa);
            assertEquals(atualizacao, "Tarefa: \n" + tarefa.toString() + "\n Foi atualizada para: \n" + novaTarefa.toString());        
        });
    }


    @Test
    public void Regra4AtualizarTarefa() {
        assertThrows(NullPointerException.class, () -> { 
            Tarefa tarefa = new Tarefa("Comprar Café", "Comprar café no mercado da esquina", "21/03/2024", Prioridade.ALTA);
            gerenciadorTarefas.criaTarefa(tarefa);
            
            Tarefa novaTarefa = new Tarefa("Comprar Café", "Comprar café no mercado da esquina", "", Prioridade.ALTA);
            String atualizacao = gerenciadorTarefas.atualizaTarefa(tarefa, novaTarefa);
            assertEquals(atualizacao, "Tarefa: \n" + tarefa.toString() + "\n Foi atualizada para: \n" + novaTarefa.toString());        
        });
    }

    @Test
    public void Regra5AtualizarTarefa() {
        assertThrows(NullPointerException.class, () -> { 
            Tarefa tarefa = new Tarefa("Comprar Café", "Comprar café no mercado da esquina", "21/03/2024", Prioridade.ALTA);
            gerenciadorTarefas.criaTarefa(tarefa);
            
            Tarefa novaTarefa = new Tarefa("Comprar Café", "Comprar café no mercado da esquina", "21/03/2024", null);
            String atualizacao = gerenciadorTarefas.atualizaTarefa(tarefa, novaTarefa);
            assertEquals(atualizacao, "Tarefa: \n" + tarefa.toString() + "\n Foi atualizada para: \n" + novaTarefa.toString());        
        });
    }

    @Test
    public void Regra6AtualizarTarefa() {
        assertThrows(NullPointerException.class, () -> { 
            Tarefa tarefa = new Tarefa("Estudar Java", "Comprar curso on-line", "21/03/2024", Prioridade.ALTA);
            Tarefa novaTarefa = new Tarefa("Comprar Café", "Comprar café no mercado da esquina", "21/03/2024", Prioridade.ALTA);
            String atualizacao = gerenciadorTarefas.atualizaTarefa(tarefa, novaTarefa);
            assertEquals(atualizacao, "Tarefa: \n" + tarefa.toString() + "\n Foi atualizada para: \n" + novaTarefa.toString());        
        });
    }

    @Test
    public void Regra1ExclusaoTarefa() {
        Tarefa tarefa = new Tarefa("Comprar café", "Passar no mercado e comprar café São Braz", "12/02/2024", Prioridade.ALTA);
        gerenciadorTarefas.criaTarefa(tarefa);

        String novaSaida = gerenciadorTarefas.deletaTarefa(tarefa);

        assertEquals(novaSaida, "Tarefa: \n" + tarefa.toString() + "\n foi deletada!");
    }
    
    @Test
    public void Regra2ExclusaoTarefa() {
        assertThrows(NullPointerException.class, () -> { 
            Tarefa tarefa = new Tarefa("Comprar Café", "Passar no mercado e comprar café São Braz", "12/02/2024", Prioridade.ALTA);
            gerenciadorTarefas.criaTarefa(tarefa);
    
            Tarefa tarefaExcluir = new Tarefa("", "Passar no mercado e comprar café São Braz", "12/02/2024", Prioridade.ALTA);
            
            String novaSaida = gerenciadorTarefas.deletaTarefa(tarefaExcluir);
        });
    }
    
    @Test
    public void Regra3ExclusaoTarefa() {
        assertThrows(NullPointerException.class, () -> { 
            Tarefa tarefa = new Tarefa("Comprar Café", "Passar no mercado e comprar café São Braz", "12/02/2024", Prioridade.ALTA);
            gerenciadorTarefas.criaTarefa(tarefa);
    
            Tarefa tarefaExcluir = new Tarefa("Comprar Café", "", "12/02/2024", Prioridade.ALTA);
            
            String novaSaida = gerenciadorTarefas.deletaTarefa(tarefaExcluir);
        });
    }

    @Test
    public void Regra4ExclusaoTarefa() {
        assertThrows(NullPointerException.class, () -> { 
            Tarefa tarefa = new Tarefa("Comprar Café", "Passar no mercado e comprar café São Braz", "12/02/2024", Prioridade.ALTA);
            gerenciadorTarefas.criaTarefa(tarefa);
    
            Tarefa tarefaExcluir = new Tarefa("Comprar Café", "Passar no mercado e comprar café São Braz", "", Prioridade.ALTA);
            
            String novaSaida = gerenciadorTarefas.deletaTarefa(tarefaExcluir);                
        });
    }

    @Test
    public void Regra5ExclusaoTarefa() {
        assertThrows(NullPointerException.class, () -> { 
            Tarefa tarefa = new Tarefa("Comprar Café", "Passar no mercado e comprar café São Braz", "12/02/2024", Prioridade.ALTA);
            gerenciadorTarefas.criaTarefa(tarefa);
    
            Tarefa tarefaExcluir = new Tarefa("Comprar Café", "Passar no mercado e comprar café São Braz", "12/02/2024", null);
            
            String novaSaida = gerenciadorTarefas.deletaTarefa(tarefaExcluir);
        });
    }

    @Test
    public void Regra6ExclusaoTarefa() {
        assertThrows(NullPointerException.class, () -> { 
            Tarefa tarefa = new Tarefa("Comprar Café", "Passar no mercado e comprar café São Braz", "12/02/2024", Prioridade.ALTA);
            String novaSaida = gerenciadorTarefas.deletaTarefa(tarefa);
        });
    }

    @Test
    public void Regra1ListagemTarefa() {
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
    public void Regra2ListagemTarefa() {
        String tarefas = gerenciadorTarefas.listaTarefas();
        String tarefasEsperadas = "";
        assertEquals(tarefas, tarefasEsperadas);
    }

}
