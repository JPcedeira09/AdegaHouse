package com.example.guiay.adegahouse.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.guiay.adegahouse.config.ConfiguracaoFirebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;

public class Produto implements Serializable, Parcelable {

    private String descricao;
    private boolean disponivel;
    private String nome;
    private String quantidade;//trocar para Integer
    private String valor;//trocar para double

    public Produto() {
    }

    public Produto(String descricao, boolean disponivel, String nome, String quantidade, String valor) {
        this.descricao = descricao;
        this.disponivel = disponivel;
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    protected Produto(Parcel in) {
        descricao = in.readString();
        disponivel = in.readByte() != 0;
        nome = in.readString();
        quantidade = in.readString();
        valor = in.readString();
    }

    public static final Creator<Produto> CREATOR = new Creator<Produto>() {
        @Override
        public Produto createFromParcel(Parcel in) {
            return new Produto(in);
        }

        @Override
        public Produto[] newArray(int size) {
            return new Produto[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(descricao);
        dest.writeByte((byte) (disponivel ? 1 : 0));
        dest.writeString(nome);
        dest.writeString(quantidade);
        dest.writeString(valor);
    }
}
