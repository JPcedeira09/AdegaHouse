package com.example.guiay.adegahouse.model;


import java.lang.reflect.Array;
import java.util.List;


public class Pedido {
    private List<ItensPedido> Itens;
    private ValoresPedido ValoresPedido;
    private DadosCliente DadosClientes;




    public Pedido() {

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

    public DadosCliente getDadosCliente() {
        return DadosClientes;
    }

    public void setDadosCliente(DadosCliente DadosClientes) {
        this.DadosClientes = DadosClientes;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "Itens=" + Itens +
                ", ValoresPedido=" + ValoresPedido +
                ", DadosClientes=" + DadosClientes +
                '}';
    }
}
