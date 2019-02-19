package com.example.guiay.adegahouse.adapter;

import android.content.Context;
import android.content.DialogInterface;
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
import com.example.guiay.adegahouse.model.Pedido;
import com.example.guiay.adegahouse.model.ValoresPedido;

import java.util.List;

public class AdapterPedidos extends RecyclerView.Adapter<AdapterPedidos.MyViewHolder> {

    private List<Pedido> pedidos;
    private Context context;


    public AdapterPedidos(List<Pedido> pp, Context cc) {
        this.pedidos = pp;
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

        Pedido pedido = pedidos.get(position);
        holder.pedido.setText(pedido.getItensCarrinho());
        holder.pedido.setText((CharSequence) pedido.getUsuario());
        holder.valorFinal.setText("R$ " + pedido.getValorTotal());
    }

    @Override
    public int getItemCount() {


        return pedidos.size();
    }
    //Fazendo o alertDialog
   /* public void abrirAlerta(View view){
        AlertDialog.Builder dialog = new  AlertDialog.Builder(context);

        dialog.setTitle("Status do pedido");
        dialog.setMessage("blablablablabla");

        //Configura as Açoes do botao
        dialog.setPositiveButton("Recusado", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.setNegativeButton("Recusado", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.create();
        dialog.show();

    }*/


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView pedido;
        TextView valorFinal;
        TextView data;
        Button status;

        public MyViewHolder(View itemView) {
            super(itemView);

            pedido = itemView.findViewById(R.id.textPedidoN);
            valorFinal = itemView.findViewById(R.id.textPreco);
            status = itemView.findViewById(R.id.buttonStatus);
        }
    }
}
