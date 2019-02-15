package com.example.guiay.adegahouse.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.guiay.adegahouse.R;
import com.example.guiay.adegahouse.config.ConfiguracaoFirebase;
import com.example.guiay.adegahouse.model.AtualizacaoUsuario;
import com.google.firebase.database.DatabaseReference;

public class ConfiguracoesUsuarioActivity extends AppCompatActivity {

    private EditText editTxtCpf, editTxtCep, editTxtEndereco, editTxtNumero, editTxtComplemento, editTxtCelular;
    private DatabaseReference mDatabase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracoes_usuario);

        //Configurações Iniciais
        inicializarComponentes();
        mDatabase = ConfiguracaoFirebase.getFirebase();


        // Configurações Toolbar
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbarPrincipal);
        toolbar.setTitle("Configurações");
        setSupportActionBar( toolbar );
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    //Salvar dados alterados no Database
    public void salvar(){

        DatabaseReference mDatabase = ConfiguracaoFirebase.getFirebase();
        DatabaseReference usuarioRef = mDatabase
                .child("Usuarios");
        usuarioRef.setValue(this);
    }

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
