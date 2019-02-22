package com.example.guiay.adegahouse.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.guiay.adegahouse.R;
import com.example.guiay.adegahouse.activity.PedidosCardapio;
import com.example.guiay.adegahouse.activity.PopActivity;
import com.example.guiay.adegahouse.model.Pedido;
import com.example.guiay.adegahouse.model.ValoresPedido;

import java.util.List;

public class AdapterPedidos extends RecyclerView.Adapter<AdapterPedidos.MyViewHolder> {

    private List<Pedido> listaPedidos;
    private Context context;


    public AdapterPedidos(List<Pedido> pp, Context cc) {
        this.listaPedidos = pp;
        this.context = cc;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_pedidos, parent,false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Pedido pedido = listaPedidos.get(position);
        holder.textHora.setText(pedido.getValoresPedido().getDataPedido());
        holder.textPedidoN.setText(position +   pedido.getDadosCliente().getNome());
        holder.textValor.setText("R$ " + String.valueOf (pedido.getValoresPedido().getValorTotalProduto()));
        holder.buttonStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context.getApplicationContext(),PopActivity.class);
                context.getApplicationContext().startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {


        return listaPedidos.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textPedidoN;
        TextView textValor;
        Button buttonStatus;
        TextView textHora;

        public MyViewHolder(View itemView) {
            super(itemView);

            textPedidoN = itemView.findViewById(R.id.textPedidoN);
            textValor = itemView.findViewById(R.id.textValorFinal);
            buttonStatus = itemView.findViewById(R.id.buttonStatus);
            textHora = itemView.findViewById(R.id.textHora);
        }
    }
}
