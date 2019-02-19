package com.example.guiay.adegahouse.Activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;


import com.example.guiay.adegahouse.Adapter.AdapterProduto;
import com.example.guiay.adegahouse.InformacoesProduto;
import com.example.guiay.adegahouse.R;
import com.example.guiay.adegahouse.config.ConfiguracaoFirebase;
import com.example.guiay.adegahouse.listener.RecyclerItemClickListener;
import com.example.guiay.adegahouse.model.Usuario;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;
import java.util.List;

public class TelaCardapio1 extends AppCompatActivity {

    private FirebaseAuth autenticacao;
    private DatabaseReference mDatabase;

    private RecyclerView recyclerProdutosCardapio;
    private List<Produto> produtos = new ArrayList<>();
    private AdapterProduto adapterProduto;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cardapio1);

        //Configurar toolbar
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbarPrincipal);
        toolbar.setTitle("CARDAPIO");
        setSupportActionBar( toolbar );

        //BottomNavigation
         configuraBottomNavigation();

        //configuracoes iniciais
        iniciailizarComponentes();
        autenticacao = ConfiguracaoFirebase.getFirebaseAutentificacao();

        recuperarProdutos();




    }

    public void configuraBottomNavigation(){

        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.bnve);
        bottomNavigationViewEx.enableAnimation(true);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(true);
    }

    private void recuperarProdutos(){
        //configurações database
        mDatabase = FirebaseDatabase.getInstance().getReference();

        DatabaseReference produtosRef = mDatabase
                .child("Adega")
                .child("Produtos");

        produtosRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                produtos.clear();

                for (DataSnapshot child: dataSnapshot.getChildren()){
                    System.out.println(child);
                    Produto produto = child.getValue(Produto.class);
                    System.out.println(produto);
                    produtos.add(produto);
                }
                adapterProduto.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                System.out.print(databaseError.toException());
            }
        });
        //Configurando evendo de click no produto
        recyclerProdutosCardapio.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        this,
                        recyclerProdutosCardapio,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Produto produtoSelecionado = produtos.get(position);
                                Intent i = new Intent(TelaCardapio1.this, InformacoesProduto.class);
                                i.putExtra("informações", produtoSelecionado);
                                startActivity(i);
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    //botão de opções da toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_sair :
                deslogarUsuario();
                startActivity(new Intent(getApplicationContext(), Login.class));
                break;

            case R.id.menu_Configuracoes :
                abrirConfiguracoes();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    //botão Sair
    private void deslogarUsuario(){

        try {
            autenticacao.signOut();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Pagina de configurações do usuario
    private void abrirConfiguracoes(){
        startActivity(new Intent(TelaCardapio1.this, ConfiguracoesUsuarioActivity.class));
    }

    private void iniciailizarComponentes(){
        recyclerProdutosCardapio = findViewById(R.id.recyclerProdutosCardapio);
        //Configura recyclerView
        recyclerProdutosCardapio.setLayoutManager(new LinearLayoutManager(this));
        recyclerProdutosCardapio.setHasFixedSize(true);
        adapterProduto = new AdapterProduto(produtos,this);
        recyclerProdutosCardapio.setAdapter(adapterProduto);
    }

}








