package com.example.guiay.adegahouse.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.guiay.adegahouse.R;
import com.example.guiay.adegahouse.config.ConfiguracaoFirebase;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth autenficaçao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro__cadastro);
         //Apple
    }

    @Override
   protected void onStart() {
        super.onStart();
         usuarioLogado();
    }

    public void btCadastrar(View view){
     startActivity(new Intent(this, Cadastro.class));

    }
    public void btLogar(View view){
     startActivity(new Intent(this,Login.class));


    }
    public void usuarioLogado(){
        autenficaçao = ConfiguracaoFirebase.getFirebaseAutentificacao();

        if (autenficaçao.getCurrentUser() !=null ){
            abrirPedidosCardapio();
        }
    }
    public void abrirPedidosCardapio(){
        startActivity(new Intent(this,PedidosCardapio.class)); //(Fiz Alteraçao aqui e rodou enao o problema esta no else if )
    }
}
