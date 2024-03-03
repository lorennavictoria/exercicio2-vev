package com.vev;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Classe GerenciadorTarefas é responsável por gerenciar as operações relacionadas às tarefas.
 */
public class GerenciadorTarefas {
    
    List<Tarefa> tarefas;

    public GerenciadorTarefas(){
        this.tarefas = new ArrayList<>();
    }
    
    
    /**
     * Cria uma nova tarefa e a adiciona à lista de tarefas.
     * @param tarefa A tarefa a ser criada e adicionada.
     * @return Uma mensagem indicando se a tarefa foi criada com sucesso.
     */
    public String criaTarefa(Tarefa tarefa){
        this.tarefas.add(tarefa);

        if (tarefas.contains(tarefa)){
            return "Tarefa criada com sucesso!";
        }
        return null;
    }


    /**
     * Atualiza uma tarefa existente na lista de tarefas com uma nova tarefa.
     * @param tarefaAntiga A tarefa a ser substituída.
     * @param novaTarefa A nova tarefa que substituirá a tarefa antiga.
     * @return Uma mensagem indicando se a tarefa foi atualizada com sucesso.
     */
    public String atualizaTarefa(Tarefa tarefaAntiga, Tarefa novaTarefa) {
       
        this.tarefas.remove(tarefaAntiga);
        this.tarefas.add(novaTarefa);


       if (this.tarefas.contains(novaTarefa)){
        return "Tarefa: " + tarefaAntiga.toString() + "foi atualizada para" + novaTarefa.toString();
       }
       return null;
    }


    /**
     * Deleta uma tarefa da lista de tarefas.
     * @param tarefa A tarefa a ser deletada.
     * @return Uma mensagem indicando se a tarefa foi deletada com sucesso.
     */
    public String deletaTarefa(Tarefa tarefa){
        this.tarefas.remove(tarefa);

        if (!this.tarefas.contains(tarefa)){
            return  "Tarefa" + tarefa.toString() + "foi deletada!";
        }
        return null;
    }


    /**
     * Lista as tarefas ordenadas por data de vencimento e prioridade.
     * @return Uma string contendo a representação das tarefas ordenadas.
     */
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