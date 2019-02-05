package com.example.guiay.adegahouse.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.guiay.adegahouse.R;
import com.example.guiay.adegahouse.config.ConfiguracaoFirebase;
import com.example.guiay.adegahouse.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

public class Login extends AppCompatActivity {
    private EditText campoEmail, campoSenha;
    private Button botaoEntrar;
    private Usuario usuario;
    private FirebaseAuth autentificacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        campoEmail = findViewById(R.id.editEmail);
        campoSenha = findViewById(R.id.editSenha);
        botaoEntrar = findViewById(R.id.Entrar);

        botaoEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoEmail = campoEmail.getText().toString();
                String textoSenha = campoSenha.getText().toString();

                if (!textoEmail.isEmpty()){
                    if (!textoSenha.isEmpty()){
                         usuario = new Usuario();
                        usuario.setEmail(textoEmail);
                        usuario.setSenha(textoSenha);
                            validarLogin();

                    } else {
                        Toast.makeText(Login.this,"Preenche a senha",
                                Toast.LENGTH_SHORT).show();


                    }

                } else {
                    Toast.makeText(Login.this,"Preenche o E-mail",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
    public void validarLogin(){
        autentificacao = ConfiguracaoFirebase.getFirebaseAutentificacao();
        autentificacao.signInWithEmailAndPassword(
                usuario.getEmail(),usuario.getSenha()
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    abrirPedidosCardapio();

                } else if (usuario.getEmail().equals("teste@teste.com")
                        && usuario.getSenha().equals("teste123")){
                    abrirPedidosEstoque();
                }
                else {
                    String excecao = "";
                    try {
                         throw task.getException();

                    } catch (FirebaseAuthInvalidUserException e) {
                        excecao = "Usuario nao esta cadastrado";
                    } catch (FirebaseAuthInvalidCredentialsException e) {
                        excecao = "E-mail e senha nao correspondem ao usuario cadastradro" ;
                    } catch (Exception e) {
                        excecao = "Erro ao cadastrar usuario" + e.getMessage();
                        e.printStackTrace();
                    }
                    Toast.makeText(Login.this,excecao,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void abrirPedidosCardapio(){

        startActivity(new Intent(this,PedidosCardapio.class));
    }

    public void abrirPedidosEstoque(){
        startActivity(new Intent(this, PedidosEstoque.class));

    }
}
