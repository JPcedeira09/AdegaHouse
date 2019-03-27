package com.example.guiay.adegahouse;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.guiay.adegahouse.model.ValoresPedido;

import java.util.List;

public class AdapterPedidosActivity extends RecyclerView.Adapter<AdapterPedidosActivity.MyViewHolder> {

    private List<ValoresPedido> pedidos;
    private Context context;

    public AdapterPedidosActivity(List<ValoresPedido> pedidos, Context context) {
        this.pedidos = pedidos;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterPedidosActivity.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_adapter_pedidos, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        ValoresPedido pedido = pedidos.get(i);
        holder.numero.setText(pedido.getNumeroPedido());
        holder.valor.setText("R$ " + pedido.getValorTotalProduto());

    }

    @Override
    public int getItemCount() {

        return pedidos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView numero;
        TextView valor;


        public MyViewHolder(View itemView) {
            super(itemView);

            numero = itemView.findViewById(R.id.textNumeroNome);
            valor = itemView.findViewById(R.id.textValorPedido);

        }
    }
}


