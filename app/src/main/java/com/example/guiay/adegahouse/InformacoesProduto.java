package com.example.guiay.adegahouse;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.guiay.adegahouse.Activity.Produto;
import com.example.guiay.adegahouse.Activity.TelaCardapio1;
//import com.example.guiay.adegahouse.Adapter.AdapterProdutoInfo;
import com.example.guiay.adegahouse.config.ConfiguracaoFirebase;
import com.example.guiay.adegahouse.config.UsuarioFirebase;
import com.example.guiay.adegahouse.listener.RecyclerItemClickListener;
import com.example.guiay.adegahouse.model.ItemPedido;
import com.example.guiay.adegahouse.model.Usuario;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class InformacoesProduto extends AppCompatActivity {


    private TextView nome;
    private TextView valor;
    private TextView disponivel;
    private Button botaoAddCarrinho;

    private Produto produtoSelecionado;

    private DatabaseReference mDatabase;


    private String idUsuarioLogado;
    private Usuario usuario;


    private List<Produto> produtos = new ArrayList<>();
    private List<ItemPedido> itensCarrinho = new ArrayList<>();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacoes_produto);







        //--------------------------------Configura toolbar-------------------------------------------------
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbarPrincipal);
        toolbar.setTitle("Produto");
        setSupportActionBar( toolbar );
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        //-----------------------------Configura componentes------------------------------------------------
        iniciailizarComponentes();
        recuperarInformacaoProdutos();
        recuperarDadosUsuario();

        idUsuarioLogado = UsuarioFirebase.getIdUsuario();




        //------------------------------Recupera produto para exibição--------------------------------------------
        produtoSelecionado = (Produto) getIntent().getSerializableExtra("produtoSelecionado");
            if(produtoSelecionado != null){

                nome.setText(produtoSelecionado.getNome());
                valor.setText("R$" + String.valueOf(produtoSelecionado.getValor()));
                if(produtoSelecionado.isDisponivel() == true){
                    disponivel.setText("Disponivel");
                }else{
                    disponivel.setText("Indisponivel");
                }

                
            }
    }




    //-------------------------Recuperar os dados do usuário----------------------------------------------
    private void recuperarDadosUsuario(){

        DatabaseReference usuariosRef = mDatabase
                .child("Usuarios")
                .child(idUsuarioLogado);

        usuariosRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue() !=null){
                    usuario = dataSnapshot.getValue(Usuario.class);
                }
                recuperarPedido();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void recuperarPedido() {
    }

    //---------------------------------Recuperar informações do produto------------------------------------
    private void recuperarInformacaoProdutos() {
        //configurações database
        mDatabase = FirebaseDatabase.getInstance().getReference();

        DatabaseReference produtosRef = mDatabase
                .child("Adega")
                .child("Produtos");

        produtosRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                produtos.clear();

                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    System.out.println(child);
                    Produto produto = child.getValue(Produto.class);
                    System.out.println(produto);
                    produtos.add(produto);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                System.out.print(databaseError.toException());
            }
        });
    }

    //--------------------------------------Envio do produto para o pedido-------------------------------------

    private void confirmarProduto(final int posicao) {

        botaoAddCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Produto produtoConfirmado = produtos.get(posicao);
                ItemPedido itemPedido = new ItemPedido();
                itemPedido.setIdProduto(produtoConfirmado.getIdProduto());
                itemPedido.setDescricao(produtoConfirmado.getDescricao());
                itemPedido.setNomeProduto(produtoConfirmado.getNome());
                itemPedido.setValorProduto(produtoConfirmado.getValor());
                itemPedido.setQuantidade(produtoConfirmado.getQuantidade());
                itensCarrinho.add(itemPedido);


            }
        });
    }

        private void iniciailizarComponentes () {
            //-------------------------------------Configura produto selecionado---------------------------------
            nome = findViewById(R.id.textNomeProduto);
            valor = findViewById(R.id.textValorInfo);
            disponivel = findViewById(R.id.txtDisponivelInfo);
            botaoAddCarrinho = findViewById(R.id.buttonAddCarinho);
        }

    }

