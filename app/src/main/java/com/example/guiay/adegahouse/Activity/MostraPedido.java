package com.example.guiay.adegahouse.activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.guiay.adegahouse.R;
import com.example.guiay.adegahouse.adapter.AdapterMostra;
import com.example.guiay.adegahouse.config.ConfiguracaoFirebase;
import com.example.guiay.adegahouse.model.DadosCliente;
import com.example.guiay.adegahouse.model.ItensPedido;
import com.example.guiay.adegahouse.model.Pedido;
import com.example.guiay.adegahouse.model.ValoresPedido;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MostraPedido extends AppCompatActivity {

    private DatabaseReference firebaseRef;
    private RecyclerView recycler;
    private List<Pedido> listaMPedidos = new ArrayList<>();
    //private TextView textEndereco, textEnderecoEntrega,textItens,textPagamento,texteAutorizado;
    //private Button botaoAceite, botaoRecusado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostra_pedido);

        //Inicializar Componentes
        firebaseRef = ConfiguracaoFirebase.getFirebase();
        recycler = findViewById(R.id.recylerMostraPedido);
        /*textEnderecoEntrega = findViewById(R.id.textEndEntrega);
        textEndereco = findViewById(R.id.textEnd);
        textItens = findViewById(R.id.textItens);
        textPagamento = findViewById(R.id.textPagamento);
        texteAutorizado = findViewById(R.id.textAutorizado);
        botaoAceite = findViewById(R.id.buttonAceitar);
        botaoRecusado = findViewById(R.id.buttonAlterar);*/


        //Configurar o RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recycler.setLayoutManager(layoutManager);
        recycler.setHasFixedSize(true);
        final AdapterMostra adapterMostra = new AdapterMostra(listaMPedidos,this);
        recycler.setAdapter(adapterMostra);

        //Recupera dados no Firebase
        DatabaseReference mostraPedidosRef = firebaseRef
                .child("Pedidos");


        mostraPedidosRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                   for (DataSnapshot ds: dataSnapshot.getChildren()){


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




                       listaMPedidos.add(pedido);


                    /*listaMPedidos.add(ds.getValue(Pedido .class));
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println(ds);*/

                } adapterMostra.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




    }
}
