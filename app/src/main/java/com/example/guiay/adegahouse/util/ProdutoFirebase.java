package com.example.guiay.adegahouse.util;

import android.support.annotation.NonNull;

import com.example.guiay.adegahouse.config.ConfiguracaoFirebase;
import com.example.guiay.adegahouse.model.Produto;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProdutoFirebase {

    private static List<Produto> produtos = new ArrayList<Produto>();
    private static Produto produto;

    public static void create(Produto produto){
        ConfiguracaoFirebase.getFirebase()
                .child("Teste")//trocar para produto
                .child(produto.getNome())
                .setValue(produto);
    }

    public static void update(Produto produto){

        Map<String,Object> produtoMap = new HashMap<String,Object>();
        produtoMap.put("valor", produto.getValor());
        produtoMap.put("descricao", produto.getDescricao());
        produtoMap.put("nome", produto.getNome());
        produtoMap.put("quantidade", produto.getQuantidade());
        produtoMap.put("disponivel",produto.isDisponivel());

        ConfiguracaoFirebase.getFirebase()
                .child("Teste")//trocar para produto
                .child(produto.getNome())
                .updateChildren(produtoMap);
    }

    public static void delete(Produto produto){
        DatabaseReference childRef = ConfiguracaoFirebase.getFirebase().child("Teste").child("uidX");
        childRef.removeValue();
    }

    public Produto getOne(String uid){

        DatabaseReference childRef = ConfiguracaoFirebase.getFirebase().child("Teste");//Trocar para produto

        childRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    produto = ds.getValue(Produto.class);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        return produto;
    }

    public List<Produto> listAll(){

        DatabaseReference childRef = ConfiguracaoFirebase.getFirebase().child("Teste");//Trocar para produto

        childRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                produtos.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    produtos.add(ds.getValue(Produto.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        return produtos;
    }
    
}
