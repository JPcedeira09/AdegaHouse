package com.example.guiay.adegahouse.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guiay.adegahouse.R;
import com.example.guiay.adegahouse.activity.AdicionarProduto;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 */
public class addProdutosFragment extends Fragment {

    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference("Produtos" );



    public addProdutosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        DatabaseReference Produtos = referencia.child("Teste");

        AdicionarProduto adicionarProduto = new AdicionarProduto();
        adicionarProduto.setDescriçao("Teste");
        adicionarProduto.setNome("kaue");
        adicionarProduto.setDisponivel(false);
        adicionarProduto.setQuantidade(10);
        adicionarProduto.setValor(13);

        Produtos.child("teste").setValue(Produtos);



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_produto, container, false);
    }

}
