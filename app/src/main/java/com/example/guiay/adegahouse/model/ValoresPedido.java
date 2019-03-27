package com.example.guiay.adegahouse.model;

public class ValoresPedido {

    private Double valorTotalProduto;
    private String dataPedido;
    private String statusPedido;
    private Boolean pedidoAceite;
    private String numeroPedido;

    public ValoresPedido() {
        super();
    }

    public ValoresPedido(Double valorTotalProduto, String dataPedido, String statusPedido, Boolean pedidoAceite, String numeroPedido) {
        super();
        this.valorTotalProduto = valorTotalProduto;
        this.dataPedido = dataPedido;
        this.statusPedido = statusPedido;
        this.pedidoAceite = pedidoAceite;
        this.numeroPedido = numeroPedido;
    }

    public String getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(String numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Double getValorTotalProduto() {
        return valorTotalProduto;
    }
    public void setValorTotalProduto(Double valorTotalProduto) {
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
        return "ValoresPedido [valorTotalProduto=" + valorTotalProduto + ", dataPedido=" + dataPedido
                + ", statusPedido=" + statusPedido + ", pedidoAceite=" + pedidoAceite + "]";
    }

}
