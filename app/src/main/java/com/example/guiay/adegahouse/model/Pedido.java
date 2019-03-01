package com.example.guiay.adegahouse.model;


import java.io.Externalizable;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.security.Key;
import java.util.List;


public  class Pedido {
    private String key;
    private List<ItensPedido> Itens;
    private ValoresPedido ValoresPedido;
    private DadosCliente DadosClientes;




    public Pedido() {

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<ItensPedido> getItens() {
        return Itens;
    }

    public void setItens(List<ItensPedido> itens) {
        Itens = itens;
    }

    public com.example.guiay.adegahouse.model.ValoresPedido getValoresPedido() {
        return ValoresPedido;
    }

    public void setValoresPedido(com.example.guiay.adegahouse.model.ValoresPedido valoresPedido) {
        ValoresPedido = valoresPedido;
    }

    public DadosCliente getDadosClientes() {
        return DadosClientes;
    }

    public void setDadosClientes(DadosCliente dadosClientes) {
        DadosClientes = dadosClientes;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "Id='" + key + '\'' +
                ", Itens=" + Itens +
                ", ValoresPedido=" + ValoresPedido +
                ", DadosClientes=" + DadosClientes +
                '}';
    }
}

