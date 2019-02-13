package com.example.guiay.adegahouse.model;

public class Pedido {
    private String itensCarrinho;
    private String valorTotal;
    private String pedidoHora;
    private String pedidoDistancia;



    public Pedido() {


    }

    public String getItensCarrinho() {
        return itensCarrinho;
    }

    public void setItensCarrinho(String itensCarrinho) {
        this.itensCarrinho = itensCarrinho;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getPedidoHora() {
        return pedidoHora;
    }

    public void setPedidoHora(String pedidoHora) {
        this.pedidoHora = pedidoHora;
    }

    public String getPedidoDistancia() {
        return pedidoDistancia;
    }

    public void setPedidoDistancia(String pedidoDistancia) {
        this.pedidoDistancia = pedidoDistancia;
    }
}
