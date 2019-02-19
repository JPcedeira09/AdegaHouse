package com.example.guiay.adegahouse.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guiay.adegahouse.R;
import com.example.guiay.adegahouse.adapter.AdapterPedidos;
import com.example.guiay.adegahouse.adapter.AdapterProduto;
import com.example.guiay.adegahouse.config.ConfiguracaoFirebase;
import com.example.guiay.adegahouse.model.Pedido;
import com.example.guiay.adegahouse.model.Produto;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class pedidosRealizadosFragment extends Fragment {

    private DatabaseReference firebaseref;
    private RecyclerView recyclerPedidos;
    private List<Produto> produtos = new ArrayList<>();

    public pedidosRealizadosFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pedidos_realizados, container, false);

        //Configuraçoes iniciais
        recyclerPedidos = view.findViewById(R.id.recyclerPedido);
        firebaseref = ConfiguracaoFirebase .getFirebase();

        //Configuraçoes do RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerPedidos.setLayoutManager(layoutManager);
        recyclerPedidos.setHasFixedSize(true);
        final AdapterProduto adapterPedido = new AdapterProduto(produtos,getActivity());
        recyclerPedidos.setAdapter(adapterPedido);

        //Recupera dados do Firebase
        DatabaseReference pedidosRef = firebaseref
                .child("Teste");
        pedidosRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                produtos.clear();

                //Long aLong = dataSnapshot.getChildrenCount();
                //System.out.println("Esse é o count dos Childs do Pedidos:"+aLong);

                for (DataSnapshot ds : dataSnapshot.getChildren()){
                  produtos.add(ds.getValue(Produto.class));
                }
                adapterPedido.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

         return view;
    }

}
