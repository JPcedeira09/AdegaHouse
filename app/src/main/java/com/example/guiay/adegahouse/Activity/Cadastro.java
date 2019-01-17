package com.example.guiay.adegahouse.Activity;

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

public class Cadastro extends AppCompatActivity {
    private EditText campoNome,campoEmail,campoSenha;
    private Button botaoCadastrar;
    private FirebaseAuth autenticacao;
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        campoNome = findViewById(R.id.editNome);
        campoEmail = findViewById(R.id.editEmail);
        campoSenha = findViewById(R.id.editSenha);
        botaoCadastrar = findViewById(R.id.Cadastrar);

        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoNome  = campoNome.getText().toString();
                String textoEmail = campoEmail.getText().toString();
                String textoSenha = campoSenha.getText().toString();
                //Validar se os campos foram preenchidos
                if (!textoNome.isEmpty()){
                    if (!textoEmail.isEmpty()){
                        if (!textoSenha.isEmpty()){
                            usuario = new Usuario();
                            usuario.setNome(textoNome);
                            usuario.setEmail(textoEmail);
                            usuario.setSenha(textoSenha);
                            cadastrarUsuario();

                        } else {
                            Toast.makeText(Cadastro.this,"Preenche a senha",
                                    Toast.LENGTH_SHORT).show();


                        }

                    } else {
                        Toast.makeText(Cadastro.this,"Preenche o E-mail",
                                Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(Cadastro.this,"Preenche o nome",
                            Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
    public void cadastrarUsuario(){
        autenticacao = ConfiguracaoFirebase.getFirebaseAutentificacao();
        autenticacao.createUserWithEmailAndPassword(
                usuario.getEmail(),usuario.getSenha())
        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    finish();


                } else {
                    Toast.makeText(Cadastro.this,"Erro ao cadastrar o usuario",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}
