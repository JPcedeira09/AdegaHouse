package com.example.guiay.adegahouse.model;

import com.example.guiay.adegahouse.config.ConfiguracaoFirebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;

public class AdicionarProduto {

    private String descricao;
    private boolean disponivel;
    private String nome;
    private double quantidade;
    private double valor;



    public AdicionarProduto() {
    }

    public void salvar(){
        DatabaseReference firebaseRef = ConfiguracaoFirebase.getFirebase();
        DatabaseReference addProdutoRef =firebaseRef.child("Teste").child("sera??");
           addProdutoRef.setValue(this);

    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descriçao) {
        this.descricao = descriçao;
    }

    @Exclude
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

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
