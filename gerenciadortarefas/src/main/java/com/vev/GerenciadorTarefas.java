package com.vev;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorTarefas {
    
    List<Tarefa> tarefas;

    public GerenciadorTarefas(){
        this.tarefas = new ArrayList<>();
    }

    public String criaTarefa(Tarefa tarefa){
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

    public String deletaTarefa(Tarefa tarefa){
        this.tarefas.remove(tarefa);

        if (!this.tarefas.contains(tarefa)){
            return  "Tarefa" + tarefa.toString() + "foi deletada!";
        }
        return null;
    }

    public String listaTarefas(){
        String saida = "";
        for (Tarefa tarefa : tarefas) {
            saida += tarefa.toString() + "\n";
        }
        return saida;
    }

}