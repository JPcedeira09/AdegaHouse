package com.example.guiay.adegahouse.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guiay.adegahouse.R;
import com.example.guiay.adegahouse.config.ConfiguracaoFirebase;
import com.google.firebase.database.DatabaseReference;

/**
 * A simple {@link Fragment} subclass.
 */
public class pedidosRealizadosFragment extends Fragment {

    private DatabaseReference firebaseref;
    private RecyclerView recyclerView;


    public pedidosRealizadosFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pedidos_realizados, container, false);

        //Configuraçoes iniciais
        //firebaseref = ConfiguracaoFirebase.

        recyclerView = view.findViewById(R.id.recylerView);
        //Configurar o adapter

        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        //recyclerView.setAdapter();

        return view;
    }

}
