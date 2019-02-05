package com.example.guiay.adegahouse.Activity;

public class Produtos {

    private String descricao;
    private boolean disponivel;
    private String nome;
    private String quantidade;
    private String valor;

    public Produtos() {
    }

    public Produtos(String descricao, boolean disponivel, String nome, String quantidade, String valor) {
        this.descricao = descricao;
        this.disponivel = disponivel;
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
