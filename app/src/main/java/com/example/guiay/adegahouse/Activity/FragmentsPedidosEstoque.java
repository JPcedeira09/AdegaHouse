package com.example.guiay.adegahouse.Activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.guiay.adegahouse.Fragment.EstoqueFragment;
import com.example.guiay.adegahouse.Fragment.PedidosFragment;
import com.example.guiay.adegahouse.R;

public class FragmentsPedidosEstoque extends AppCompatActivity {

    private Button buttonEstoque, buttonPedidos;
    private EstoqueFragment estoqueFragment;
    private PedidosFragment pedidosFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments_pedidos_estoque);

        buttonEstoque = findViewById(R.id.buttonEstoque);
        buttonPedidos = findViewById(R.id.buttonPedidos);

            estoqueFragment = new EstoqueFragment();

            //Configurar objeto para o Framento
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameConteudo, estoqueFragment);
        transaction.commit();

        buttonEstoque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                estoqueFragment = new EstoqueFragment();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo, estoqueFragment);
                transaction.commit();
            }
        });

        buttonPedidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pedidosFragment = new PedidosFragment();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo, pedidosFragment);
                transaction.commit();

            }
        });

    }
}
