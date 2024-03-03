package com.vev;

public class Tarefa {
    
    private String titulo;
    private String descricao;
    private String dataVencimento;
    private Prioridade prioridade;

    public Tarefa(String titulo, String descricao, String dataVencimento, Prioridade prioridade) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataVencimento = dataVencimento;
        this.prioridade = prioridade;
    }

    public void setTitulo(String novoTitulo){
        this.titulo = novoTitulo;
    }

    public void setDescricao(String novaDescricao){
        this.descricao = novaDescricao;
    }

    public void setDataVencimento(String novaDataVencimento){
        this.dataVencimento = novaDataVencimento;
    }
    
    public void setPrioridade(Prioridade novaPrioridade){
        this.prioridade = novaPrioridade;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public String getDataVencimento() {
        return this.dataVencimento;
    }

    public Prioridade getprioridade() {
        return this.prioridade;
    }
   
}
