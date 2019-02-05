package com.example.guiay.adegahouse.config;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class ConfiguracaoFirebase {

    private static FirebaseAuth autenticacao;
    private static DatabaseReference referenciaFirebase;
    private static StorageReference referenciaStorage;

    //retorna a instancia do FirebaseAuth

    public static FirebaseAuth getFirebaseAutentificacao() {
        if (autenticacao == null) {
            autenticacao = FirebaseAuth.getInstance();
        }
        return autenticacao;
    }

    public static DatabaseReference getFirebase() {
        if (referenciaFirebase == null) {
            referenciaFirebase = FirebaseDatabase.getInstance().getReference("Adega");
        }
        return referenciaFirebase;
    }
    public static StorageReference getFirebaseStorage() {
        if (referenciaStorage == null) {
            referenciaStorage = FirebaseStorage.getInstance().getReference();
        }
        return referenciaStorage;
    }
}
