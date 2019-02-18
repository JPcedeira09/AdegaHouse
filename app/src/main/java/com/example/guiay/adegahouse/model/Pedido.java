package com.example.guiay.adegahouse.model;


import java.lang.reflect.Array;
import java.util.List;

public class Pedido {
    private String itensCarrinho;
    private double valorTotal;
    private Usuario usuario;

    public Pedido() {

    }

    public String getItensCarrinho() {
        return itensCarrinho;
    }

    public void setItensCarrinho(String itensCarrinho) {
        this.itensCarrinho = itensCarrinho;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
