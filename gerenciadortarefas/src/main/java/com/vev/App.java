package com.vev;

/**
 * Gerenciador de Tarefas
 * 
 * @lorenna
 */
public class App 
{
    public static void main( String[] args )
    {
        GerenciadorTarefas gerenciadorTarefas = new GerenciadorTarefas();

        //Inserindo
        Tarefa tarefa1 = new Tarefa("Comprar café", "Passar no mercado na volta e comprar café", "12/02/2024", Prioridade.ALTA);
        Tarefa tarefa2 = new Tarefa("Estudar Java", "Preparar para a prova", "10/02/2023", Prioridade.ALTA);
        
        String saida1 = gerenciadorTarefas.criaTarefa(tarefa1);
        String saida2 = gerenciadorTarefas.criaTarefa(tarefa2);

        System.out.println(saida1);
        System.out.println(saida2);

        // Atualizando
        Tarefa tarefa3 = new Tarefa("Estudar Java", "Preparar para a prova e para o projeto", "10/02/2023", Prioridade.ALTA);
        String saida3 = gerenciadorTarefas.atualizaTarefa(tarefa2, tarefa3);
        
        System.out.println(saida3);

        // Deletando
        String saida4 = gerenciadorTarefas.deletaTarefa(tarefa3);
        System.out.println(saida4);

        // Listando
        Tarefa tarefa4 = new Tarefa("Estudar Python", "Por pura diversão", "10/04/2023", Prioridade.ALTA);
        gerenciadorTarefas.criaTarefa(tarefa4);
        
        Tarefa tarefa5 = new Tarefa("Estudar Java", "Preparar para a prova", "10/02/2023", Prioridade.ALTA);
        Tarefa tarefa6 = new Tarefa("Fazer exercícios", "Treino na academia", "08/01/2024", Prioridade.BAIXA);
        gerenciadorTarefas.criaTarefa(tarefa5);
        gerenciadorTarefas.criaTarefa(tarefa6);

        String lista = gerenciadorTarefas.listaTarefas();
        System.out.println(lista);        
    }
}
