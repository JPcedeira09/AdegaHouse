package com.example.guiay.adegahouse.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.guiay.adegahouse.R;
import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;

public class Slider extends IntroActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

      /* //Sumir Toobar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); // Para o layout preencher toda tela do cel (remover a barra de tit.)
        getSupportActionBar().hide();

        //Fazendo Slider
        addSlide(new SimpleSlide.Builder()
                        .title("Me chupa")
                        .description("Minha rolinha")
                        .image(R.drawable.um)
                        .build() );

        addSlide(new SimpleSlide.Builder()
                .title("Quero dar o cu")
                .description("Me come")
                .image(R.drawable.dois)
                .build() );

        addSlide(new SimpleSlide.Builder()
                .title("Key eu te odeio")
                .description("Me come")
                .image(R.drawable.tres)
                .build() );

        addSlide(new SimpleSlide.Builder()
                .title("Key eu te odeio")
                .description("A vai te toma no cu")
                .image(R.drawable.tres)
                .build() ); */



    }
}
