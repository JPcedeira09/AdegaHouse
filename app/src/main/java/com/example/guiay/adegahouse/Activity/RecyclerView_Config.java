package com.example.guiay.adegahouse.Activity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.guiay.adegahouse.R;

import java.util.List;

public class RecyclerView_Config {
    private Context mContext;
    private ProdutosAdapter mProdutosAdapter;
    public void setConfig(RecyclerView recyclerView, Context context, List <Produtos> produtos, List<String> keys){
        mContext = context;
        mProdutosAdapter = new ProdutosAdapter(produtos,keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mProdutosAdapter);
    }


    class ProdutosItemView extends RecyclerView.ViewHolder{

        private TextView mDescricao;
        private TextView mNome;
        private TextView mValor;

        private String key;

        public ProdutosItemView (ViewGroup parent) {
            super(LayoutInflater.from(mContext).
            inflate(R.layout.tela_cardapio_item, parent, false));

            mNome = (TextView) itemView.findViewById(R.id.nome_txtView);
            mDescricao = (TextView) itemView.findViewById(R.id.descricao_txtView);
            mValor = (TextView) itemView.findViewById(R.id.valor_txtView);
        }

        public void bind (Produtos produtos, String key) {
            mNome.setText(produtos.getNome());
            mDescricao.setText(produtos.getDescricao());
            mValor.setText(produtos.getValor());
            this.key = key;

        }
    }

    class ProdutosAdapter extends RecyclerView.Adapter<ProdutosItemView>{
        private List<Produtos> mProdutosList;
        private List<String> mKeys;

        public ProdutosAdapter(List<Produtos> mProdutosList, List<String> mKeys) {
            this.mProdutosList = mProdutosList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public ProdutosItemView onCreateViewHolder(@NonNull ViewGroup parent, int ViewType) {
            return new ProdutosItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull ProdutosItemView holder, int position) {
            holder.bind (mProdutosList.get(position), mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mProdutosList.size();
        }
    }
}
