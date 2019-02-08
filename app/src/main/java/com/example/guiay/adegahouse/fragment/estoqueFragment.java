package com.example.guiay.adegahouse.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.guiay.adegahouse.R;
import com.example.guiay.adegahouse.adapter.AdapterProduto;
import com.example.guiay.adegahouse.config.ConfiguracaoFirebase;
import com.example.guiay.adegahouse.model.Produto;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import br.com.ifood.cursoandroid.ifoodprojeto.listener.RecyclerItemClickListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class estoqueFragment extends Fragment {
    private DatabaseReference firebaseRef;
    private RecyclerView recyclerProdutos;
    private AdapterProduto adapterProduto;
    private List<Produto> produtos = new ArrayList<>();

    public estoqueFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_estoque, container, false);

         //Inicializar os Componentes
        recyclerProdutos = view.findViewById(R.id.recyclerProdutos);
        firebaseRef = ConfiguracaoFirebase.getFirebase();


        //Configurar o RecyclerView
        recyclerProdutos.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerProdutos.setHasFixedSize(true);
        adapterProduto = new AdapterProduto(produtos,getActivity());
        recyclerProdutos.setAdapter(adapterProduto);

        //Adiciona evento de clique no Recyclcerview
        recyclerProdutos.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), recyclerProdutos,
                new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }

            @Override
            public void onLongItemClick(View view, int position) {
                Produto produtoSelecionado = produtos.get(position);
                produtoSelecionado.remover();
                Toast.makeText(getActivity(),"Produto excluido com sucesso ",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));


        //Recupera os dados do Firebase
        DatabaseReference produtoRef = firebaseRef.child("Teste"); //Trocar para produto
        produtoRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                 produtos.clear();
                for (DataSnapshot ds: dataSnapshot.getChildren()){
                    produtos.add(ds.getValue(Produto.class));

                }
                adapterProduto.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });





        // Inflate the layout for this fragment
        return view;
    }

}
