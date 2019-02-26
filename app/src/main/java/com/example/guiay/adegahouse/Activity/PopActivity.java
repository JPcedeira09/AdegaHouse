package com.example.guiay.adegahouse.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.guiay.adegahouse.R;
import com.example.guiay.adegahouse.config.ConfiguracaoFirebase;
import com.example.guiay.adegahouse.model.Pedido;
import com.google.firebase.database.DatabaseReference;

public class PopActivity extends Activity {

    //private TextView pergunta;
    //private Button aceito,negado,pronto,transito,preparo;
    //private DatabaseReference firebaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);

        //Configuraçoes iniciais
        /*pergunta = findViewById(R.id.textPergunta);
        aceito = findViewById(R.id.buttonAceito);
        negado = findViewById(R.id.buttonNegado);
        pronto = findViewById(R.id.buttonPreparo);
        transito = findViewById(R.id.buttonPronto);
        preparo = findViewById(R.id.buttonPreparo);
        firebaseRef = ConfiguracaoFirebase.getFirebase();*/

        //Recupera dados do FireBase
     /*   DatabaseReference statusRef = firebaseRef
                .child("Pedidos")
                .child("")
                .child("ValoresPedido");*/

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8), (int) (height*.7));


        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);

    }

}
