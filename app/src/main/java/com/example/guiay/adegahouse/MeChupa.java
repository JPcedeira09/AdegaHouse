package com.example.guiay.adegahouse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MeChupa extends AppCompatActivity {

    private TextView textOla , textOi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_chupa);

        textOla = findViewById(R.id.textGostoso);
        textOi = findViewById(R.id.textDelicia);


    }
}
