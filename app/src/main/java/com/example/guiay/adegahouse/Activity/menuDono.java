package com.example.guiay.adegahouse.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.guiay.adegahouse.R;
import com.example.guiay.adegahouse.config.ConfiguracaoFirebase;
import com.example.guiay.adegahouse.fragment.EditPerfilFragment;
import com.example.guiay.adegahouse.fragment.EnviarEmailFragment;
import com.example.guiay.adegahouse.fragment.ListaHistoricoFragment;
import com.example.guiay.adegahouse.fragment.PoliticasUsoFragment;
import com.example.guiay.adegahouse.fragment.PromocoesFragment;
import com.example.guiay.adegahouse.fragment.addProdutosFragment;
import com.example.guiay.adegahouse.fragment.EstoqueFragment;
import com.example.guiay.adegahouse.fragment.PedidosRealizadosFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class menuDono extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_dono);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarPrincipal);
        setSupportActionBar(toolbar);

        autenticacao = ConfiguracaoFirebase.getFirebaseAutentificacao();

        //Configurar o Bottom Navigation View
        configuraBottomNavigation();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.promocoes_dono) {
            PromocoesFragment promocoesFragment = new PromocoesFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.viewPage, promocoesFragment);
            fragmentTransaction.commit();

        } else if (id == R.id.enviar_email) {
            EnviarEmailFragment enviarEmailFragment = new EnviarEmailFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.viewPage, enviarEmailFragment);
            fragmentTransaction.commit();

        } else if (id == R.id.edit_perfil) {
            EditPerfilFragment editPerfilFragment = new EditPerfilFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.viewPage, editPerfilFragment);
            fragmentTransaction.commit();

        } else if (id == R.id.lista_historico) {
            ListaHistoricoFragment listaHistoricoFragment = new ListaHistoricoFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.viewPage, listaHistoricoFragment);
            fragmentTransaction.commit();

        } else if (id == R.id.como_usar) {
            startActivity(new Intent(this, Slider.class));

        } else if (id == R.id.politicas_uso) {
            PoliticasUsoFragment politicasUsoFragment = new PoliticasUsoFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.viewPage, politicasUsoFragment);
            fragmentTransaction.commit();

        } else if (id == R.id.sair) {
            autenticacao.signOut();
            startActivity(new Intent(getApplicationContext(), Login.class));
        }

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }

        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_dono, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }

    }


