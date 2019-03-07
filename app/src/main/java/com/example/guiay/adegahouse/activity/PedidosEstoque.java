package com.example.guiay.adegahouse.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.guiay.adegahouse.R;
import com.example.guiay.adegahouse.config.ConfiguracaoFirebase;
import com.example.guiay.adegahouse.fragment.addProdutosFragment;
import com.example.guiay.adegahouse.fragment.EstoqueFragment;
import com.example.guiay.adegahouse.fragment.PedidosRealizadosFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class PedidosEstoque extends AppCompatActivity {

    private FirebaseAuth autenticacao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos_estoque);
        //Sumir Action Bar
       // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); // Para o layout preencher toda tela do cel (remover a barra de tit.)
        //getSupportActionBar().hide();

        //Confugurar toolbar
        Toolbar toolbar = findViewById(R.id.toolbarPrincipal);
        toolbar.setTitle("Adega House");
        //setSupportActionBar( toolbar );

        //Configuraçao de Objetos
        autenticacao = ConfiguracaoFirebase.getFirebaseAutentificacao();

        //Configurar o bottom navigation view
        configuraBottomNavigation();

    }

    /**
     * Metodo responsavel  por criar o BottomNavigation
     */
    public void configuraBottomNavigation() {
        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.bottomNavigation);
        bottomNavigationViewEx.enableAnimation(true);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(true);

        //Habilitar Navegaçao
        habilitarNavegaçao(bottomNavigationViewEx);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.viewPage, new PedidosRealizadosFragment()).commit();


    }

    /**
     * Metodo responsavel por tratar eventos de click na BottomNavigation
     *
     * @param viewEx
     */

    private void habilitarNavegaçao(BottomNavigationViewEx viewEx) {
        viewEx.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                switch (item.getItemId()) {
                    case R.id.ic_pedidos:
                        fragmentTransaction.replace(R.id.viewPage, new PedidosRealizadosFragment()).commit();
                        return true;
                    case R.id.ic_estoque:
                        fragmentTransaction.replace(R.id.viewPage, new EstoqueFragment()).commit();
                        return true;
                    case R.id.ic_adicionar:
                        fragmentTransaction.replace(R.id.viewPage, new addProdutosFragment()).commit();
                        return true;

                }
                return false;
            }
        });


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
            case R.id.menu_sair:
                deslogarUsuario();
                startActivity(new Intent(getApplicationContext(), Login.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void deslogarUsuario() {
        try {
            autenticacao.signOut();

        } catch (Exception e) {

            e.printStackTrace();
        }

    }
}
