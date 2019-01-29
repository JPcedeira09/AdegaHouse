package com.example.guiay.adegahouse.Activity;

import android.content.Intent;
import android.support.design.internal.BottomNavigationItemView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.example.guiay.adegahouse.R;
import com.example.guiay.adegahouse.config.ConfiguracaoFirebase;
import com.google.firebase.auth.FirebaseAuth;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class TelaCardapio1 extends AppCompatActivity {

    private FirebaseAuth autenticacao;



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
}
