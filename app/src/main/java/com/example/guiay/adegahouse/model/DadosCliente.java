package com.example.guiay.adegahouse.model;

public class DadosCliente {

    private String complemento;
    private String endereco;
    private String numero;
    private String cpf;
    private String celular;
    private String cep;
    private String nome;
    private String email;

    public DadosCliente() {

    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "DadosCliente{" +
                "complemento='" + complemento + '\'' +
                ", endereco='" + endereco + '\'' +
                ", numero='" + numero + '\'' +
                ", cpf='" + cpf + '\'' +
                ", celular='" + celular + '\'' +
                ", cep='" + cep + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
