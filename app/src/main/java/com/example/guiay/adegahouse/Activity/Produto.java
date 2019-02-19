package com.example.guiay.adegahouse.Activity;

import java.io.Serializable;

public class Produto implements Serializable {

    private String descricao;
    private boolean disponivel;
    private String nome;
    private Integer quantidade;
    private double valor;

    public Produto() {
    }

    public Produto(String descricao, boolean disponivel, String nome, Integer quantidade, double valor) {
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

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
