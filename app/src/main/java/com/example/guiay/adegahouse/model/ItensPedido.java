package com.example.guiay.adegahouse.model;



public class ItensPedido  {

    private Long qtd;
    private String nome;
    private Double totalItem;

    public Long getQtd() {
        return qtd;
    }

    public void setQtd(Long qtd) {
        this.qtd = qtd;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(Double totalItem) {
        this.totalItem = totalItem;
    }

    @Override
    public String toString() {
        return "ItensPedido{" +
                "qtd=" + qtd +
                ", nome='" + nome + '\'' +
                ", totalItem=" + totalItem +
                '}';
    }
}
