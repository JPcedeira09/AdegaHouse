package com.example.guiay.adegahouse.util;

import android.support.annotation.NonNull;

import com.example.guiay.adegahouse.config.ConfiguracaoFirebase;
import com.example.guiay.adegahouse.model.DadosCliente;
import com.example.guiay.adegahouse.model.ItensPedido;
import com.example.guiay.adegahouse.model.Pedido;
import com.example.guiay.adegahouse.model.ValoresPedido;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PedidoFirebase {

    private static List<Pedido> pedidos = new ArrayList<Pedido>();
    private static Pedido pedido;


    public static void updateStatus(Pedido pedido, Boolean statuBool, String statusSting) {

        pedido.getValoresPedido().setStatusPedido(statusSting);
        pedido.getValoresPedido().setPedidoAceite(statuBool);

        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> map =
                mapper.convertValue(pedido, new TypeReference<Map<String, Object>>() {
                });

        ConfiguracaoFirebase.getFirebase()
                .child("Pedidos")
                .updateChildren(map);

    }
    public static Pedido getone(String uid){
        DatabaseReference childRef = ConfiguracaoFirebase.getFirebase().child("Pedidos");

        childRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    pedido = ds.getValue(Pedido.class);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return pedido;

    }

    public static List<Pedido> listAll() {
        //Recupera dados do Firebase
        DatabaseReference childRef = ConfiguracaoFirebase.getFirebase().child("Pedidos");

        childRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                pedidos.clear();


                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    Pedido pedido = new Pedido();


                    final DataSnapshot valoresPedidoDS = ds.child("ValoresPedido");
                    ValoresPedido valoresPedido = valoresPedidoDS.getValue(ValoresPedido.class);
                    pedido.setValoresPedido(valoresPedido);

                    final DataSnapshot dadosClienteDS = ds.child("DadosCliente");
                    DadosCliente dadosCliente = dadosClienteDS.getValue(DadosCliente.class);
                    pedido.setDadosClientes(dadosCliente);

                    final DataSnapshot itensDS = ds.child("Itens");
                    List<ItensPedido> itensPedidos = new ArrayList<ItensPedido>();
                    for (DataSnapshot dsItem : itensDS.getChildren()) {
                        ItensPedido itensPedido = dsItem.getValue(ItensPedido.class);
                        itensPedidos.add(itensPedido);

                    }

                    pedido.setItens(itensPedidos);


                    pedidos.add(pedido);
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        return pedidos;



    }



}
