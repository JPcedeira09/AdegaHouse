package com.example.guiay.adegahouse.Activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.guiay.adegahouse.Fragment.EstoqueFragment;
import com.example.guiay.adegahouse.Fragment.HistoricoFragment;
import com.example.guiay.adegahouse.R;

public class FragmentsHistoricoEstoque extends AppCompatActivity {

    private Button buttonEstoque, buttonHistorico;
    private EstoqueFragment estoqueFragment;
    private HistoricoFragment historicoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments_historico_estoque);

        buttonEstoque = findViewById(R.id.buttonEstoque);
        buttonHistorico = findViewById(R.id.buttonHistorico);

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

        buttonHistorico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                historicoFragment = new HistoricoFragment();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo, historicoFragment);
                transaction.commit();

            }
        });

    }
}
