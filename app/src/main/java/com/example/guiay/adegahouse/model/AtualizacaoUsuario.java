package com.example.guiay.adegahouse.model;

import com.example.guiay.adegahouse.config.ConfiguracaoFirebase;
import com.google.firebase.database.DatabaseReference;

public class AtualizacaoUsuario {

    private String cpf;
    private String cep;
    private String endereco;
    private String numero;
    private String complemento;
    private String celular;

    public AtualizacaoUsuario() {
    }



    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}
