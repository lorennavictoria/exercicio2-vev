package funcionalTests;

import java.lang.NullPointerException;
import java.text.DateFormat;
import java.time.format.DateTimeParseException;
import java.util.zip.DataFormatException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.vev.GerenciadorTarefas;
import com.vev.Prioridade;
import com.vev.Tarefa;

public class TestsParticoesEquivalencia {
    
    GerenciadorTarefas gerenciadorTarefas = new GerenciadorTarefas();

    @Test
    public void CriaTarefaComTodosCamposValidos(){
        Tarefa tarefa = new Tarefa("Comprar café", "Passar no mercado na volta e comprar café", "21/03/2024", Prioridade.ALTA);
        String saida = gerenciadorTarefas.criaTarefa(tarefa);
        assertEquals(saida, "Tarefa criada com sucesso!");
    } 

    @Test
    public void CriaTarefaApenasComTituloValido(){
        assertThrows(DateTimeParseException.class, () -> { 
            Tarefa tarefa = new Tarefa("Comprar café", "", "", null);
            gerenciadorTarefas.criaTarefa(tarefa);
            fail("Deveria ter lançado NullPointerException");
        });
    } 

    @Test
    public void CriaTarefaComDataVencimentoInvalida(){
        assertThrows(DateTimeParseException.class, () -> { 
            Tarefa tarefa = new Tarefa("Comprar café", "Passar no mercado na volta e comprar café", "12/02/2024", Prioridade.ALTA);
            gerenciadorTarefas.criaTarefa(tarefa);
        });
    } 

    @Test
    public void CriaTarefaComApenasPrioridadeValida() {
        assertThrows(DateTimeParseException.class, () -> { 
     
            Tarefa tarefa = new Tarefa("", "", "", Prioridade.ALTA);
            gerenciadorTarefas.criaTarefa(tarefa);
    });
    } 

    @Test
    public void CriaTarefaComApenasDescricaoValida(){
        assertThrows(DateTimeParseException.class, () -> { 
            Tarefa tarefa = new Tarefa("", "Passar no mercado na volta e comprar café", "", null);
            String saida = gerenciadorTarefas.criaTarefa(tarefa);
        });
    } 

    @Test
    public void AtualizarTarefaApenasTitulo(){
        Tarefa tarefa = new Tarefa("Comprar café", "Passar no mercado na volta e comprar café", "21/03/2024", Prioridade.ALTA);
        gerenciadorTarefas.criaTarefa(tarefa);

        Tarefa novaTarefa = new Tarefa("Comprar chá", "Passar no mercado na volta e comprar café", "21/03/2024", Prioridade.ALTA);
        
        String atualizacao = gerenciadorTarefas.atualizaTarefa(tarefa, novaTarefa);
        assertEquals(atualizacao, "Tarefa: \n" + tarefa.toString() + "\n Foi atualizada para: \n" + novaTarefa.toString());    
    } 

    @Test
    public void AtualizarTarefaApenasDescricao(){
        Tarefa tarefa = new Tarefa("Comprar café", "Passar no mercado na volta e comprar café", "21/03/2024", Prioridade.ALTA);
        gerenciadorTarefas.criaTarefa(tarefa);

        Tarefa novaTarefa = new Tarefa("Comprar chá", "Pedir Delivery", "21/03/2024", Prioridade.ALTA);
        
        String atualizacao = gerenciadorTarefas.atualizaTarefa(tarefa, novaTarefa);
        assertEquals(atualizacao, "Tarefa: \n" + tarefa.toString() + "\n Foi atualizada para: \n" + novaTarefa.toString());    
    } 

    @Test
    public void AtualizarTarefaApenasDataDeVencimento(){
        Tarefa tarefa = new Tarefa("Comprar café", "Passar no mercado na volta e comprar café", "21/03/2024", Prioridade.ALTA);
        gerenciadorTarefas.criaTarefa(tarefa);

        Tarefa novaTarefa = new Tarefa("Comprar café", "Passar no mercado na volta e comprar café", "22/03/2024", Prioridade.ALTA);
        
        String atualizacao = gerenciadorTarefas.atualizaTarefa(tarefa, novaTarefa);
        assertEquals(atualizacao, "Tarefa: \n" + tarefa.toString() + "\n Foi atualizada para: \n" + novaTarefa.toString());    
    } 

    @Test
    public void AtualizarTarefaTodosCampos(){
        Tarefa tarefa = new Tarefa("Comprar café", "Passar no mercado na volta e comprar café", "21/03/2024", Prioridade.ALTA);
        gerenciadorTarefas.criaTarefa(tarefa);

        Tarefa novaTarefa = new Tarefa("Comprar chá", "Pedir Delivery", "22/03/2024", Prioridade.MEDIA);
        
        String atualizacao = gerenciadorTarefas.atualizaTarefa(tarefa, novaTarefa);
        assertEquals(atualizacao, "Tarefa: \n" + tarefa.toString() + "\n Foi atualizada para: \n" + novaTarefa.toString());    
    } 


    @Test
    public void AtualizarTarefaInexistente(){
        try {
            Tarefa tarefa = new Tarefa("Comprar café", "Passar no mercado na volta e comprar café", "21/03/2024", Prioridade.ALTA);
           
            Tarefa novaTarefa = new Tarefa("Comprar chá", "Pedir Delivery", "22/03/2024", Prioridade.MEDIA);
            
            String atualizacao = gerenciadorTarefas.atualizaTarefa(tarefa, novaTarefa);
        

        } catch (NullPointerException e) {

        }
    }

    @Test
    public void ExcluirTarefaExistente(){
        Tarefa tarefa = new Tarefa("Comprar café", "Passar no mercado e comprar café São Braz", "12/02/2024", Prioridade.ALTA);
        gerenciadorTarefas.criaTarefa(tarefa);

        String novaSaida = gerenciadorTarefas.deletaTarefa(tarefa);

        assertEquals(novaSaida, "Tarefa: \n" + tarefa.toString() + "\n foi deletada!");
    }
    
    @Test
    public void ExcluirTarefaInexistente(){
        assertThrows(NullPointerException.class, () -> { 
            Tarefa tarefa = new Tarefa("Comprar café", "Passar no mercado e comprar café São Braz", "12/02/2024", Prioridade.ALTA);
                
            String novaSaida = gerenciadorTarefas.deletaTarefa(tarefa);
    
        });

    }

}
