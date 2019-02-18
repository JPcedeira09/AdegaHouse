package com.example.guiay.adegahouse.Activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.guiay.adegahouse.R;
import com.example.guiay.adegahouse.config.ConfiguracaoFirebase;
import com.example.guiay.adegahouse.config.UsuarioFirebase;
import com.example.guiay.adegahouse.model.AtualizacaoUsuario;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfiguracoesUsuarioActivity extends AppCompatActivity {

    private EditText editTxtCpf, editTxtCep, editTxtEndereco, editTxtNumero, editTxtComplemento, editTxtCelular;
    private DatabaseReference mDatabase;

    private String idUsuarioLogado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracoes_usuario);

        //Configurações Iniciais
        inicializarComponentes();
        mDatabase = ConfiguracaoFirebase.getFirebase();
        recuperarDados();
        idUsuarioLogado = UsuarioFirebase.getIdUsuario();




        // Configurações Toolbar
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbarPrincipal);
        toolbar.setTitle("Configurações");
        setSupportActionBar( toolbar );
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    //Salvar dados alterados no Database
    public void salvar(){

        String email = UsuarioFirebase.getEmail();
        String cpf = editTxtCpf.getText().toString();
        String cep = editTxtCep.getText().toString();
        String endereco = editTxtEndereco.getText().toString();
        String numero = editTxtNumero.getText().toString();
        String complemento = editTxtComplemento.getText().toString();
        String celular = editTxtCelular.getText().toString();

        AtualizacaoUsuario atualizacao = new AtualizacaoUsuario(email, cpf,  cep,  endereco,  numero,  complemento,  celular);



        Map<String,Object> atualizacaoMap = new HashMap<String,Object>();
        atualizacaoMap.put("cpf", atualizacao.getCpf());
        atualizacaoMap.put("cep", atualizacao.getCep());
        atualizacaoMap.put("endereco",atualizacao.getEndereco() );
        atualizacaoMap.put("numero", atualizacao.getNumero());
        atualizacaoMap.put("complemento",atualizacao.getComplemento());
        atualizacaoMap.put("celular", atualizacao.getCelular() );

        mDatabase = FirebaseDatabase.getInstance().getReference();
        DatabaseReference usuarioRef = mDatabase
                .child("Usuarios")
                .child(UsuarioFirebase.getIdUsuario())
                .child("dados_pessoais");
        usuarioRef.updateChildren(atualizacaoMap);
    }

    private void recuperarDados(){
        //Configuração Database
        mDatabase = FirebaseDatabase.getInstance().getReference();

        System.out.println(UsuarioFirebase.getIdUsuario().toString());
        System.out.println(UsuarioFirebase.getIdUsuario().toString());
        System.out.println(UsuarioFirebase.getIdUsuario().toString());

        DatabaseReference dadosRef = mDatabase
                .child("Usuarios")
                .child(UsuarioFirebase.getIdUsuario())
                .child("dados_pessoais");

        dadosRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                AtualizacaoUsuario atualizacao = dataSnapshot.getValue(AtualizacaoUsuario.class);

                System.out.println(atualizacao.toString());
                editTxtCpf.setText(atualizacao.getCpf());
                editTxtCep.setText(atualizacao.getCep());
                editTxtEndereco.setText(atualizacao.getEndereco());
                editTxtNumero.setText(atualizacao.getNumero());
                editTxtComplemento.setText(atualizacao.getComplemento());
                editTxtCelular.setText(atualizacao.getCelular());


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    // Enviando dados para Firebase
    public void validarDadosUsuario(View view){

        // Valida se os campos foram preenchidos
        String cpf = editTxtCpf.getText().toString();
        String cep = editTxtCep.getText().toString();
        String endereco = editTxtEndereco.getText().toString();
        String numero = editTxtNumero.getText().toString();
        String complemento = editTxtComplemento.getText().toString();
        String celular = editTxtCelular.getText().toString();

        if(!cpf.isEmpty()){
            if(!cep.isEmpty()){
                if(!endereco.isEmpty()){
                    if(!numero.isEmpty()){
                            if(!celular.isEmpty()){



                            AtualizacaoUsuario dados = new AtualizacaoUsuario();
                            dados.setCpf(cpf);
                            dados.setCep(cep);
                            dados.setEndereco(endereco);
                            dados.setNumero(numero);
                            dados.setComplemento(complemento);
                            dados.setCelular(celular);

                            salvar();
                            
                            exibirMensagem("Dados atualizados com sucesso!");
                            finish();

                        }else{
                            exibirMensagem("Informe seu celular!");
                        }

                    }else{
                        exibirMensagem("Digite o numero do endereço!");
                    }

                }else{
                    exibirMensagem("Digite seu endereço!");
                }

            }else{
                exibirMensagem("Digite seu CEP!");
            }

        }else{
            exibirMensagem("Digite seu CPF!");
        }
    }

    private void exibirMensagem (String texto){
        Toast.makeText(this, texto, Toast.LENGTH_SHORT)
                .show();
    }

    private void inicializarComponentes(){
        editTxtCpf = findViewById(R.id.editTxtCpf);
        editTxtCep = findViewById(R.id.editTxtCep);
        editTxtEndereco = findViewById(R.id.editTxtEndereco);
        editTxtNumero = findViewById(R.id.editTxtNumero);
        editTxtComplemento = findViewById(R.id.editTxtComplemento);
        editTxtCelular = findViewById(R.id.editTxtCelular);
    }


}
