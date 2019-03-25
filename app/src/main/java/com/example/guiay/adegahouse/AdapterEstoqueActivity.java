package com.example.guiay.adegahouse;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.guiay.adegahouse.Activity.Pedidos;
import com.example.guiay.adegahouse.Activity.PedidosCardapio;
import com.example.guiay.adegahouse.Activity.Produto;
import com.example.guiay.adegahouse.Adapter.AdapterProduto;

import java.util.List;

public class AdapterEstoqueActivity extends RecyclerView.Adapter<AdapterEstoqueActivity.MyViewHolder> {

    private List<Produto> produtos;
    private Context context;

    public AdapterEstoqueActivity(List<Produto> produtos, Context context) {
        this.produtos = produtos;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterEstoqueActivity.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_adapter_estoque, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        Produto produto = produtos.get(i);
        holder.nome.setText(produto.getNome());
        holder.valor.setText("R$ " + produto.getValor());
        if(produto.isDisponivel() == true){
            holder.disponivel.setText("Disponivel");
        }else{
            holder.disponivel.setText("Indisponivel");
        }
    }

    @Override
    public int getItemCount() {

        return produtos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nome;
        TextView valor;
        TextView disponivel;

        public MyViewHolder(View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.txtNomeProdutoPedido);
            valor = itemView.findViewById(R.id.txtValorProdutoPedido);
            disponivel = itemView.findViewById(R.id.txtDisponivelProdutoPedido);
        }
    }
}

