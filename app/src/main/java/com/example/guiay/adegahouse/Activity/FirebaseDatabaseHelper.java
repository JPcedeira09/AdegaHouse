package com.example.guiay.adegahouse.Activity;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper {

    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceProdutos;
    private List<Produto> produtos = new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded (List<Produto> produtos, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public FirebaseDatabaseHelper(){

        mDatabase = FirebaseDatabase.getInstance();
        mReferenceProdutos = mDatabase.getReference("Teste");

    }

    public void readProdutos (final DataStatus dataStatus){
        mReferenceProdutos.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                produtos.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode : dataSnapshot.getChildren()){
                   keys.add (keyNode.getKey());
                   Produto produto = keyNode.getValue(Produto.class);
                   produtos.add(produto);

                }
                dataStatus.DataIsLoaded(produtos,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
