package com.example.guiay.adegahouse.model;

public class AtualizacaoLoja {

    private String email;
    private String nome;
    private String razao;
    private String endereco;
    private String cnpj;
    private String contato;

    public AtualizacaoLoja(){
    }

    public AtualizacaoLoja (String email,String nome, String razao, String endereco, String cnpj, String contato) {

        this.email = email;
        this.nome = nome;
        this.razao = razao;
        this.endereco = endereco;
        this.cnpj = cnpj;
        this.contato = contato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
}
