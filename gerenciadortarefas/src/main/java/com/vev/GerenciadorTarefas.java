package com.vev;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorTarefas {
    
    List<Tarefa> tarefas;

    public GerenciadorTarefas(){
        this.tarefas = new ArrayList<>();
    }

    public String criaTarefa(String titulo, String descricao, String dataVencimento, Prioridade prioridade){
        Tarefa tarefa = new Tarefa(titulo, descricao, dataVencimento, prioridade);
        this.tarefas.add(tarefa);

        if (tarefas.contains(tarefa)){
            return "Tarefa inserida com sucesso!";
        }
        return null;
    }

    public String atualizaTarefa(Tarefa tarefaAntiga, Tarefa novaTarefa) {
       for (int i = 0; i < this.tarefas.size(); i++) {
            if (this.tarefas.get(i) == tarefaAntiga){
                this.tarefas.remove(i);
                this.tarefas.add(novaTarefa);
            }
       }

       if (this.tarefas.contains(novaTarefa)){
        return "Tarefa: " + tarefaAntiga.toString() + "foi atualizada para" + novaTarefa.toString();
       }
       return null;
    }

}