package com.example.guiay.adegahouse.config;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UsuarioFirebase {

    public static String getIdUsuario(){

        FirebaseAuth autenticacao = ConfiguracaoFirebase.getFirebaseAutentificacao();
        return autenticacao.getCurrentUser().getUid();
    }

    public static String getEmail(){

        FirebaseAuth autenticacao = ConfiguracaoFirebase.getFirebaseAutentificacao();
        return autenticacao.getCurrentUser().getEmail();
    }


}
