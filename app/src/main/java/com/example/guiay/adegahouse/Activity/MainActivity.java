package com.example.guiay.adegahouse.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.guiay.adegahouse.Activity.Cadastro;
import com.example.guiay.adegahouse.Activity.Login;
import com.example.guiay.adegahouse.R;
import com.example.guiay.adegahouse.config.ConfiguracaoFirebase;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth autenficaçao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro__cadastro);

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
        startActivity(new Intent(this,TelaCardapio1.class));
    }
}
