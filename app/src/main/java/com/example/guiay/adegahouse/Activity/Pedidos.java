package com.example.guiay.adegahouse.Activity;

import com.example.guiay.adegahouse.model.ItensCarrinho;
import com.example.guiay.adegahouse.model.Usuarios;
import com.example.guiay.adegahouse.model.ValoresPedido;

import java.util.List;

public class Pedidos {

    private String key;
    private ValoresPedido valoresPedido;
    private Usuarios usuario;
    private List<ItensCarrinho> itensCarrinho;

    public Pedidos(String key, ValoresPedido valoresPedido, Usuarios usuario, List<ItensCarrinho> itensCarrinho) {
        super();
        this.key = key;
        this.valoresPedido = valoresPedido;
        this.usuario = usuario;
        this.itensCarrinho = itensCarrinho;
    }

    public Pedidos() {
        super();
    }

    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public ValoresPedido getValoresPedido() {
        return valoresPedido;
    }
    public void setValoresPedido(ValoresPedido valoresPedido) {
        this.valoresPedido = valoresPedido;
    }
    public Usuarios getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
    public List<ItensCarrinho> getItensCarrinho() {
        return itensCarrinho;
    }
    public void setItensCarrinho(List<ItensCarrinho> itensCarrinho) {
        this.itensCarrinho = itensCarrinho;
    }

    @Override
    public String toString() {
        return "Pedido [key=" + key + ", valoresPedido=" + valoresPedido + ", usuario=" + usuario + ", itensCarrinho="
                + itensCarrinho + "]";
    }

}
