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

import com.example.guiay.adegahouse.R;
import com.example.guiay.adegahouse.adapter.AdapterPedidos;
import com.example.guiay.adegahouse.config.ConfiguracaoFirebase;
import com.example.guiay.adegahouse.listerner.RecyclerItemClickListener;
import com.example.guiay.adegahouse.model.DadosCliente;
import com.example.guiay.adegahouse.model.ItensPedido;
import com.example.guiay.adegahouse.model.Pedido;
import com.example.guiay.adegahouse.model.ValoresPedido;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.example.guiay.adegahouse.util.PedidoFirebase;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PedidosRealizadosFragment extends Fragment {

    private String teste;
    private DatabaseReference firebaseref;
    private RecyclerView recyclerPedidos;
    private List<Pedido> listaPedidos = new ArrayList<>();



    public PedidosRealizadosFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pedidos_realizados, container, false);

        //Configuraçoes iniciais
        /*recyclerPedidos = view.findViewById(R.id.recyclerPedido);
        firebaseref = ConfiguracaoFirebase.getFirebase();


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
                        Pedido pedidoSelecionado = listaPedidos.get(position);
                        sendData(pedidoSelecionado);



                        Pedido pedidoSelecionado = listaPedidos.get(position);
                        PedidosRealizadosFragment fragment = new PedidosRealizadosFragment();
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("pedidoSelecionado", pedidoSelecionado);
                        fragment.setArguments(bundle);



                    }

                    @Override
                    public void onLongItemClick(View view, int position) {


                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                }));


        //listaPedidos = PedidoFirebase.listAll();

        //Recupera dados do Firebase
       /* DatabaseReference pedidosRef = firebaseref
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
        System.out.println(""); */

        return view;
    }

    /*public void sendData(  Pedido pedido){
        Intent i = new Intent(getActivity().getBaseContext(),
                MostraPedido.class);


        //PACK DATA
        i.putExtra("pedido_selecionado", (Parcelable) pedido);

        //START ACTIVITY
        getActivity().startActivity(i);


    }*/


}

