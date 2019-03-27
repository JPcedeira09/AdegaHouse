package com.example.guiay.adegahouse;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.guiay.adegahouse.config.ConfiguracaoFirebase;
import com.example.guiay.adegahouse.config.UsuarioFirebase;
import com.example.guiay.adegahouse.model.AtualizacaoLoja;
import com.example.guiay.adegahouse.model.AtualizacaoUsuario;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class PerfilLojaActivity extends AppCompatActivity {

    private EditText editTxtNome, editTxtRazao, editTxtCNPJ, editTxtEndereco, editTxtContato;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_loja);

        //Configurações Iniciais
        inicializarComponentes();
        mDatabase = ConfiguracaoFirebase.getFirebase();
        recuperarDados();

    }

    //Salvar dados alterados no Database
    public void salvar(){

        String email = UsuarioFirebase.getEmail();
        String nome = editTxtNome.getText().toString();
        String razao = editTxtRazao.getText().toString();
        String endereco = editTxtEndereco.getText().toString();
        String cnpj = editTxtCNPJ.getText().toString();
        String contato = editTxtContato.getText().toString();


        AtualizacaoLoja atualizacao = new AtualizacaoLoja(email, nome,  razao,  endereco,  cnpj,  contato);



        Map<String,Object> atualizacaoMap = new HashMap<String,Object>();
        atualizacaoMap.put("nome", atualizacao.getNome());
        atualizacaoMap.put("razao", atualizacao.getRazao());
        atualizacaoMap.put("endereco",atualizacao.getEndereco() );
        atualizacaoMap.put("CNPJ", atualizacao.getCnpj());
        atualizacaoMap.put("telefone1",atualizacao.getContato());


        mDatabase = FirebaseDatabase.getInstance().getReference();
        DatabaseReference usuarioRef = mDatabase
                .child("Adega")
                .child("DadosAdega");
        usuarioRef.updateChildren(atualizacaoMap);
    }


    private void recuperarDados(){
        //Configuração Database
        mDatabase = FirebaseDatabase.getInstance().getReference();

        System.out.println(UsuarioFirebase.getIdUsuario().toString());
        System.out.println(UsuarioFirebase.getIdUsuario().toString());
        System.out.println(UsuarioFirebase.getIdUsuario().toString());

        DatabaseReference dadosRef = mDatabase
                .child("Adega")
                .child("DadosAdega");

        dadosRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                AtualizacaoLoja atualizacao = dataSnapshot.getValue(AtualizacaoLoja.class);

                System.out.println(atualizacao.toString());
                editTxtNome.setText(atualizacao.getNome());
                editTxtRazao.setText(atualizacao.getRazao());
                editTxtEndereco.setText(atualizacao.getEndereco());
                editTxtCNPJ.setText(atualizacao.getCnpj());
                editTxtContato.setText(atualizacao.getContato());



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    // Enviando dados para Firebase
    public void validarDadosLoja(View view){

        // Valida se os campos foram preenchidos
        String nome = editTxtNome.getText().toString();
        String razao = editTxtRazao.getText().toString();
        String endereco = editTxtEndereco.getText().toString();
        String cnpj = editTxtCNPJ.getText().toString();
        String contato = editTxtContato.getText().toString();


        if(!nome.isEmpty()){
                if(!endereco.isEmpty()){
                    if(!cnpj.isEmpty()){
                        if(!contato.isEmpty()){



                            AtualizacaoLoja dados = new AtualizacaoLoja();
                            dados.setNome(nome);
                            dados.setEndereco(endereco);
                            dados.setCnpj(cnpj);
                            dados.setContato(contato);


                            salvar();

                            exibirMensagem("Dados atualizados com sucesso!");
                            finish();

                        }else{
                            exibirMensagem("Informe o telefone para contato!");
                        }

                    }else{
                        exibirMensagem("Digite o CNPJ da loja!");
                    }

                }else{
                    exibirMensagem("Digite o endereço da loja!");
                }

        }else{
            exibirMensagem("Digite o nome da loja!");
        }
    }

    private void exibirMensagem (String texto){
        Toast.makeText(this, texto, Toast.LENGTH_SHORT)
                .show();
    }

    private void inicializarComponentes(){
        editTxtNome = findViewById(R.id.editNomeLoja);
        editTxtRazao = findViewById(R.id.editRazaoLoja);
        editTxtEndereco = findViewById(R.id.editEnderecoLoja);
        editTxtCNPJ = findViewById(R.id.editCNPJLoja);
        editTxtContato = findViewById(R.id.editContatoLoja);

    }
}
