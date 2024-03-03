package com.vev;

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
        Comparator<Tarefa> comparadorTarefas = new Comparator<Tarefa>() {
            @Override
            public int compare(Tarefa t1, Tarefa t2) {
                int prioridadeComparison = t2.getprioridade().compareTo(t1.getprioridade());
                if (prioridadeComparison != 0) {
                    return prioridadeComparison;
                }
                return t1.getDataVencimento().compareTo(t2.getDataVencimento());
            }
        };

        Collections.sort(this.tarefas, comparadorTarefas);

        String saida = "";
        for (Tarefa tarefa : this.tarefas) {
            saida += tarefa.toString() + "\n";
        }
        return saida;
    }

}