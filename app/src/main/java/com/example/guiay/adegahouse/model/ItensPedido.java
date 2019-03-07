package com.example.guiay.adegahouse.model;


import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class ItensPedido implements Serializable, Parcelable {

    private Long qtd;
    private String nome;
    private Double totalItem;

    protected ItensPedido(Parcel in) {
        if (in.readByte() == 0) {
            qtd = null;
        } else {
            qtd = in.readLong();
        }
        nome = in.readString();
        if (in.readByte() == 0) {
            totalItem = null;
        } else {
            totalItem = in.readDouble();
        }
    }

    public static final Creator<ItensPedido> CREATOR = new Creator<ItensPedido>() {
        @Override
        public ItensPedido createFromParcel(Parcel in) {
            return new ItensPedido(in);
        }

        @Override
        public ItensPedido[] newArray(int size) {
            return new ItensPedido[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (qtd == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(qtd);
        }
        dest.writeString(nome);
        if (totalItem == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(totalItem);
        }
    }
}
