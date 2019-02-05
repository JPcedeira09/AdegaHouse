package com.example.guiay.adegahouse.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.Switch;
import android.widget.Toast;

import com.example.guiay.adegahouse.R;
import com.example.guiay.adegahouse.activity.Login;
import com.example.guiay.adegahouse.model.AdicionarProduto;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.widget.Toast.*;
import static android.widget.Toast.LENGTH_SHORT;

/**
 * A simple {@link Fragment} subclass.
 */
public class addProdutosFragment extends Fragment {

    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference("Adega" );
    private EditText editNome,editDescricao,editQtq,editValor;
    private Button adicionarProduto;




    public addProdutosFragment() {
            // Required empty public constructor
        }


        @Override
        public View onCreateView (LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState){
            View view = inflater.inflate(R.layout.fragment_add_produto, container, false);

            //Inicializar
            editNome = view.findViewById(R.id.editNome);
            editDescricao = view.findViewById(R.id.editDescriçao);
            editQtq = view.findViewById(R.id.editQtd);
            editValor = view.findViewById(R.id.editValor);
            adicionarProduto = view.findViewById(R.id.addProduto);


            //Validar si os dados foram preenchidos
            adicionarProduto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String nome = editNome.getText().toString();
                    String descricao = editDescricao.getText().toString();
                    String quantidade = editQtq.getText().toString();
                    String valor = editValor.getText().toString();

                    if (!nome.isEmpty()){
                        if (!descricao.isEmpty()){
                            if (!quantidade.isEmpty()){
                                if (!valor.isEmpty()){

                                    AdicionarProduto adicionarProduto = new AdicionarProduto();
                                    adicionarProduto.setNome(nome);
                                    adicionarProduto.setDescricao(descricao);
                                    adicionarProduto.setQuantidade(Double.parseDouble(quantidade));
                                    adicionarProduto.setValor(Double.parseDouble(valor));
                                    adicionarProduto.salvar();


                                }else{
                                    Toast.makeText(getActivity(),"Digite o valor do produto",Toast.LENGTH_SHORT).show();
                                }

                            }else{
                                Toast.makeText(getActivity(),"Digite a quantidade do produto",Toast.LENGTH_SHORT).show();
                            }

                        }else{
                            Toast.makeText(getActivity(),"Digite a descrição do produto",Toast.LENGTH_SHORT).show();
                        }

                    }else {

                        Toast.makeText(getActivity(),"Digite o nome do produto",Toast.LENGTH_SHORT).show();

                    }



                }

            });





            //Salvar dados no Firebase
            DatabaseReference produtos = referencia.child("Teste");


            //Recup
            produtos.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    Log.i("FIREBASE", dataSnapshot.getValue().toString());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

            // Inflate the layout for this fragment
            return view;
        }


}
