package com.vev;

/**
 * A classe Tarefa representa uma tarefa a ser realizada, contendo informações como título, descrição, data de vencimento e prioridade.
 */
public class Tarefa {
    
    private String titulo;
    private String descricao;
    private String dataVencimento;
    private Prioridade prioridade;

    /**
     * Construtor da classe Tarefa.
     * @param titulo O título da tarefa.
     * @param descricao A descrição da tarefa.
     * @param dataVencimento A data de vencimento da tarefa no formato de string.
     * @param prioridade A prioridade da tarefa.
     */
    public Tarefa(String titulo, String descricao, String dataVencimento, Prioridade prioridade) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataVencimento = dataVencimento;
        this.prioridade = prioridade;
    }

    /**
     * Define um novo título para a tarefa.
     * @param novoTitulo O novo título da tarefa.
     */
    public void setTitulo(String novoTitulo){
        this.titulo = novoTitulo;
    }

    /**
     * Define uma nova descrição para a tarefa.
     * @param novaDescricao A nova descrição da tarefa.
     */
    public void setDescricao(String novaDescricao){
        this.descricao = novaDescricao;
    }

    /**
     * Define uma nova data de vencimento para a tarefa.
     * @param novaDataVencimento A nova data de vencimento da tarefa no formato de string.
     */
    public void setDataVencimento(String novaDataVencimento){
        this.dataVencimento = novaDataVencimento;
    }

     /**
     * Define uma nova prioridade para a tarefa.
     * @param novaPrioridade A nova prioridade da tarefa.
     */
    public void setPrioridade(Prioridade novaPrioridade){
        this.prioridade = novaPrioridade;
    }

    /**
     * Obtém o título da tarefa.
     * @return O título da tarefa.
     */
    public String getTitulo() {
        return this.titulo;
    }

    /**
     * Obtém a descrição da tarefa.
     * @return A descrição da tarefa.
     */
    public String getDescricao() {
        return this.descricao;
    }

    /**
     * Obtém a data de vencimento da tarefa.
     * @return A data de vencimento da tarefa no formato de string.
     */
    public String getDataVencimento() {
        return this.dataVencimento;
    }

    /**
     * Obtém a prioridade da tarefa.
     * @return A prioridade da tarefa.
     */
    public Prioridade getprioridade() {
        return this.prioridade;
    }
    
    /**
     * Retorna uma representação em string da tarefa.
     * @return Uma representação em string da tarefa contendo título, descrição, data de vencimento e prioridade.
     */
    public String toString(){
        return "\n Título: " + this.titulo 
            + " \n Descrição: " + this.descricao 
            + " \n Data de vencimento:" + this.dataVencimento 
            + " \n Prioridade: " + this.prioridade;
        }
   
}
