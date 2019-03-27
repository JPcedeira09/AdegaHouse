package com.example.guiay.adegahouse.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.guiay.adegahouse.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PedidosFragment extends Fragment {

    private TextView txtPedidos;

    public PedidosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pedidos, container, false);

        txtPedidos = view.findViewById(R.id.txtPedidos);
        return view;
    }

}
