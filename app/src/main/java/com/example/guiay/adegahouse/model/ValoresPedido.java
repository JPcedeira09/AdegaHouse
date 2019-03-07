package com.example.guiay.adegahouse.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class ValoresPedido implements Serializable, Parcelable {
    private double valorTotalProduto;
    private String dataPedido;
    private String statusPedido;
    private Boolean pedidoAceite;

    public ValoresPedido() {

    }

    protected ValoresPedido(Parcel in) {
        valorTotalProduto = in.readDouble();
        dataPedido = in.readString();
        statusPedido = in.readString();
        byte tmpPedidoAceite = in.readByte();
        pedidoAceite = tmpPedidoAceite == 0 ? null : tmpPedidoAceite == 1;
    }

    public static final Creator<ValoresPedido> CREATOR = new Creator<ValoresPedido>() {
        @Override
        public ValoresPedido createFromParcel(Parcel in) {
            return new ValoresPedido(in);
        }

        @Override
        public ValoresPedido[] newArray(int size) {
            return new ValoresPedido[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(valorTotalProduto);
        dest.writeString(dataPedido);
        dest.writeString(statusPedido);
        dest.writeByte((byte) (pedidoAceite == null ? 0 : pedidoAceite ? 1 : 2));
    }
}
