package com.example.guiay.adegahouse.fragment;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;

import com.example.guiay.adegahouse.R;
import com.example.guiay.adegahouse.activity.MostraPedido;
import com.example.guiay.adegahouse.activity.PopActivity;
import com.example.guiay.adegahouse.activity.Slider;
import com.example.guiay.adegahouse.adapter.AdapterPedidos;
import com.example.guiay.adegahouse.adapter.AdapterProduto;
import com.example.guiay.adegahouse.config.ConfiguracaoFirebase;
import com.example.guiay.adegahouse.model.DadosCliente;
import com.example.guiay.adegahouse.model.ItensPedido;
import com.example.guiay.adegahouse.model.Pedido;
import com.example.guiay.adegahouse.model.Produto;
import com.example.guiay.adegahouse.model.ValoresPedido;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.io.Externalizable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.ifood.cursoandroid.ifoodprojeto.listener.RecyclerItemClickListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class pedidosRealizadosFragment extends Fragment {

    private DatabaseReference firebaseref;
    private RecyclerView recyclerPedidos;
    private List<Pedido> listaPedidos = new ArrayList<>();



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
        final AdapterPedidos adapterPedido = new AdapterPedidos(listaPedidos,getActivity());
        recyclerPedidos.setAdapter(adapterPedido);

        //Evento de click no recylerView
        recyclerPedidos.addOnItemTouchListener( new RecyclerItemClickListener(getActivity(), recyclerPedidos,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        startActivity(new Intent(getActivity(), MostraPedido.class));

                    }

                    @Override
                    public void onLongItemClick(View view, int position) {


                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                }));



        //Recupera dados do Firebase
        DatabaseReference pedidosRef = firebaseref
                .child("Pedidos");

        pedidosRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listaPedidos.clear();


                for (DataSnapshot ds : dataSnapshot.getChildren()){

                    Pedido pedido = new Pedido();


                    final DataSnapshot valoresPedidoDS = ds.child("ValoresPedido");
                    ValoresPedido valoresPedido = valoresPedidoDS.getValue(ValoresPedido.class);
                    pedido.setValoresPedido(valoresPedido);

                    final DataSnapshot dadosClienteDS = ds.child("DadosCliente");
                    DadosCliente dadosCliente = dadosClienteDS.getValue(DadosCliente.class);
                    pedido.setDadosClientes(dadosCliente);

                    final DataSnapshot itensDS = ds.child("Itens");
                    List<ItensPedido> itensPedidos = new ArrayList<ItensPedido>();
                    for(DataSnapshot dsItem : itensDS.getChildren()){
                        ItensPedido itensPedido = dsItem.getValue(ItensPedido.class);
                        itensPedidos.add(itensPedido);

                    }

                    pedido.setItens(itensPedidos);




                    listaPedidos.add(pedido);
                }

               adapterPedido.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        System.out.println("");
        System.out.println("");

        System.out.println(listaPedidos.toString());

        System.out.println("");
        System.out.println("");

        return view;
    }

}
