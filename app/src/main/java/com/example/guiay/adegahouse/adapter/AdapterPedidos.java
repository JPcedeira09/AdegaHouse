package com.example.guiay.adegahouse.adapter;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.guiay.adegahouse.R;
import com.example.guiay.adegahouse.model.Pedido;

import java.util.List;

public class AdapterPedidos extends RecyclerView.Adapter<AdapterPedidos.MyViewHolder> {

    private List<Pedido> pedidos;

    public AdapterPedidos() {

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_pedidos, parent,false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Pedido pedido = pedidos.get(position);
        holder.pedido.setText(pedido.getItensCarrinho());
        holder.hora.setText(pedido.getPedidoHora());
        holder.distancia.setText(pedido.getPedidoDistancia());
        holder.valorFinal.setText("R$ " + pedido.getValorTotal());

    }

    @Override
    public int getItemCount() {


        return pedidos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView pedido;
        TextView hora;
        TextView valorFinal;
        TextView distancia;
        Button status;

        public MyViewHolder(View itemView) {
            super(itemView);

            pedido = itemView.findViewById(R.id.textPedidoN);
            hora = itemView.findViewById(R.id.textHora);
            distancia =itemView.findViewById(R.id.textDistancia);
            valorFinal = itemView.findViewById(R.id.textPreco);
            status = itemView.findViewById(R.id.buttonStatus);
        }
    }
}
