package com.example.guiay.adegahouse.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guiay.adegahouse.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PoliticasUsoFragment extends Fragment {


    public PoliticasUsoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_politicas_uso, container, false);
    }

}