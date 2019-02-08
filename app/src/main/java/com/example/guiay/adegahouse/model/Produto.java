package com.example.guiay.adegahouse.model;

import com.example.guiay.adegahouse.config.ConfiguracaoFirebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.FirebaseDatabase;

public class Produto {

    private String descricao;
    private boolean disponivel;
    private String nome;
    private String quantidade;
    private String valor;




    public Produto() {


    }


    public void remover(){
        DatabaseReference firebaseRef = ConfiguracaoFirebase.getFirebase();
        DatabaseReference  produtoRef =firebaseRef.child("Teste").child(this.nome); //trocar para produto
        produtoRef.removeValue();

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
