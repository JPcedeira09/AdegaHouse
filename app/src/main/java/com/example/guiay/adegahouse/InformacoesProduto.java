package com.example.guiay.adegahouse;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.guiay.adegahouse.Activity.Produto;
import com.example.guiay.adegahouse.Adapter.AdapterProdutoInfo;
import com.example.guiay.adegahouse.config.ConfiguracaoFirebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class InformacoesProduto extends AppCompatActivity {

    private DatabaseReference mDatabase;


    private RecyclerView recyclerInformacaoProduto;
    private List<Produto> produtos = new ArrayList<>();
    private AdapterProdutoInfo adapterProdutoInfo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacoes_produto);

        //Configura toolbar
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbarPrincipal);
        toolbar.setTitle("Produto");
        setSupportActionBar(toolbar);

        iniciailizarComponentes();
        recuperarInformacaoProdutos();


    }

    private void recuperarInformacaoProdutos() {
        //configurações database
        mDatabase = FirebaseDatabase.getInstance().getReference();

        DatabaseReference produtosRef = mDatabase
                .child("Adega")
                .child("Produtos");

        produtosRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                produtos.clear();

                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    System.out.println(child);
                    Produto produto = child.getValue(Produto.class);
                    System.out.println(produto);
                    produtos.add(produto);
                }
                adapterProdutoInfo.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                System.out.print(databaseError.toException());
            }
        });
    }

    private void iniciailizarComponentes(){
        recyclerInformacaoProduto = findViewById(R.id.recyclerInfoProduto);
        //Configura recyclerView
        recyclerInformacaoProduto.setLayoutManager(new LinearLayoutManager(this));
        recyclerInformacaoProduto.setHasFixedSize(true);
        adapterProdutoInfo = new AdapterProdutoInfo(produtos,this);
        recyclerInformacaoProduto.setAdapter(adapterProdutoInfo);
    }


}
