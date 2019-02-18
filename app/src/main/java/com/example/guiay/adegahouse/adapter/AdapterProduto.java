package com.example.guiay.adegahouse.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.guiay.adegahouse.R;
import com.example.guiay.adegahouse.model.Produto;
import java.util.List;





public class AdapterProduto extends RecyclerView.Adapter<AdapterProduto.MyViewHolder>{

    private List<Produto> produtos;
    private Context context;

    public AdapterProduto(List<Produto> p, Context c) {
        this.produtos = p;
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

            Produto produto = produtos.get(position);
            holder.nome.setText(produto.getNome());
            holder.descricao.setText(produto.getDescricao());
            holder.valor.setText("R$ " + produto.getValor());


    }


    @Override
    public int getItemCount() {


        return produtos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nome;
        TextView descricao;
        TextView valor;

        public MyViewHolder(View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.textNomeProduto);
            descricao = itemView.findViewById(R.id.textDescricao);
            valor = itemView.findViewById(R.id.textPreco);
        }
    }
}
