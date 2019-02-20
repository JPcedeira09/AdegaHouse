package com.example.guiay.adegahouse.model;

public class ValoresPedido {
    private double valorTotalProduto;
    private String dataPedido;
    private String statusPedido;
    private Boolean pedidoAceite;

    public ValoresPedido() {

    }

    public double getValorTotalProduto() {
        return valorTotalProduto;
    }

    public void setValorTotalProduto(double valorTotalProduto) {
        this.valorTotalProduto = valorTotalProduto;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }

    public Boolean getPedidoAceite() {
        return pedidoAceite;
    }

    public void setPedidoAceite(Boolean pedidoAceite) {
        this.pedidoAceite = pedidoAceite;
    }

    @Override
    public String toString() {
        return "ValoresPedido{" +
                "valorTotalProduto=" + valorTotalProduto +
                ", dataPedido='" + dataPedido + '\'' +
                ", statusPedido='" + statusPedido + '\'' +
                ", pedidoAceite=" + pedidoAceite +
                '}';
    }
}
