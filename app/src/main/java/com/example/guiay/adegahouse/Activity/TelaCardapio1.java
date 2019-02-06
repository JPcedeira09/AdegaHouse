package com.example.guiay.adegahouse.Activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.guiay.adegahouse.R;
import com.example.guiay.adegahouse.config.ConfiguracaoFirebase;
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
    private DatabaseReference firebaseRef;
    private List<Produto> produtos = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cardapio1);

        //Configurar toolbar
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbarPrincipal);
        toolbar.setTitle("Cardápio");
        setSupportActionBar( toolbar );

        //configuracoes de objetos
        autenticacao = ConfiguracaoFirebase.getFirebaseAutentificacao();

        configuraBottomNavigation();

        //configuracoes iniciais
        iniciailizarComponentes();





        //configurações database
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public void configuraBottomNavigation(){

        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.bnve);
        bottomNavigationViewEx.enableAnimation(true);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(true);

        //Habilitar navegação


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

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

    private void deslogarUsuario(){

        try {
            autenticacao.signOut();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void abrirConfiguracoes(){
        startActivity(new Intent(TelaCardapio1.this, ConfiguracoesUsuarioActivity.class));
    }

    private void iniciailizarComponentes(){
        recyclerProdutosCardapio = findViewById(R.id.recyclerProdutosCardapio);
        new FirebaseDatabaseHelper().readProdutos(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Produto> produtos, List<String> keys) {
                new RecyclerView_Config().setConfig(recyclerProdutosCardapio,TelaCardapio1.this,
                        produtos, keys);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });
    }
    private void printDatabase(){

        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference();

        System.out.println("print");

        myRef.child("Adega").child("Produtos").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot chidSnap : dataSnapshot.getChildren()) {
                    Produto produtoValue = chidSnap.getValue(Produto.class);
                    System.out.println(produtoValue.getNome());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    }




