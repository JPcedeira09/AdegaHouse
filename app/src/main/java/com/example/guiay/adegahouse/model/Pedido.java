package com.example.guiay.adegahouse.model;


import android.os.Parcel;
import android.os.Parcelable;

import java.io.Externalizable;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.security.Key;
import java.util.List;


public  class Pedido implements Serializable, Parcelable {
    private String key;
    private List<ItensPedido> Itens;
    private ValoresPedido ValoresPedido;
    private DadosCliente DadosClientes;




    public Pedido() {

    }

    protected Pedido(Parcel in) {
        key = in.readString();
        Itens = in.createTypedArrayList(ItensPedido.CREATOR);
        ValoresPedido = in.readParcelable(com.example.guiay.adegahouse.model.ValoresPedido.class.getClassLoader());
        DadosClientes = in.readParcelable(DadosCliente.class.getClassLoader());
    }

    public static final Creator<Pedido> CREATOR = new Creator<Pedido>() {
        @Override
        public Pedido createFromParcel(Parcel in) {
            return new Pedido(in);
        }

        @Override
        public Pedido[] newArray(int size) {
            return new Pedido[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(key);
        dest.writeTypedList(Itens);
        dest.writeParcelable(ValoresPedido, flags);
        dest.writeParcelable(DadosClientes, flags);
    }
}

