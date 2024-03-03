package com.vev;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GerenciadorTarefas {
    
    List<Tarefa> tarefas;

    public GerenciadorTarefas(){
        this.tarefas = new ArrayList<>();
    }

    public String criaTarefa(Tarefa tarefa){
        this.tarefas.add(tarefa);

        if (tarefas.contains(tarefa)){
            return "Tarefa criada com sucesso!";
        }
        return null;
    }

    public String atualizaTarefa(Tarefa tarefaAntiga, Tarefa novaTarefa) {
       
        this.tarefas.remove(tarefaAntiga);
        this.tarefas.add(novaTarefa);


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
        Collections.sort(tarefas, Comparator.comparing(Tarefa::getDataVencimento));
        Collections.sort(tarefas, Comparator.comparing(Tarefa::getprioridade));
        String saida = "";
        for (Tarefa tarefa : this.tarefas) {
            saida += tarefa.toString();
        }
        return saida;
    };

}