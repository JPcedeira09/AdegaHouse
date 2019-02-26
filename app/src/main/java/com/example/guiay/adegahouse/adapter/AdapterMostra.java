package com.example.guiay.adegahouse.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.guiay.adegahouse.R;
import com.example.guiay.adegahouse.model.Pedido;

import java.util.List;

public class AdapterMostra extends RecyclerView.Adapter<AdapterMostra.MyViewHolder>{

    private List<Pedido> pedidos;
    private Context context;

    public AdapterMostra(List<Pedido> p, Context c) {
        this.pedidos = p;
        this.context = c;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_produto, parent,false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Pedido pedido = pedidos.get(position);
        //holder.descricao.setText(pedido);
        //holder.preço.setText(pedido);
        //holder.total.setText("R$ " + pedido.getValor());

    }

    @Override
    public int getItemCount() {

        return pedidos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView descricao;
        TextView preço;
        TextView total;

        public MyViewHolder(View itemView) {
            super(itemView);

            descricao = itemView.findViewById(R.id.textItemDescricao);
             preço = itemView.findViewById(R.id.textItemPreco);
            total = itemView.findViewById(R.id.textTotal);
        }
    }
}

