package com.example.guiay.adegahouse.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.guiay.adegahouse.R;
import com.example.guiay.adegahouse.config.ConfiguracaoFirebase;
import com.example.guiay.adegahouse.model.Produto;
import com.google.firebase.database.DatabaseReference;


/**
 * A simple {@link Fragment} subclass.
 */
public class addProdutosFragment extends Fragment {

    private EditText editNome,editDescricao,editQtq,editValor;
    private Button adicionarProduto;
    private DatabaseReference  firebaseRef;




    public addProdutosFragment() {
            // Required empty public constructor
        }
    public void salvar(Produto produto){

        DatabaseReference firebaseRef = ConfiguracaoFirebase.getFirebase();
                firebaseRef
                .child("Teste")//trocar para produto
                .child(produto.getNome())
                .setValue(produto);

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
            firebaseRef = ConfiguracaoFirebase.getFirebase();

            //Recuperar dados
            /*DatabaseReference produtoRef = firebaseRef.child("Teste").child("sera??");
            addProdutoRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.getValue() !=null){
                        AdicionarProduto adicionarProduto = dataSnapshot.getValue(Produto.class);
                        editNome.setText(adicionarProduto.getNome());
                        editDescricao.setText(adicionarProduto.getDescricao());
                        editQtq.setText(adicionarProduto.getQuantidade());
                        editValor.setText(adicionarProduto.getValor());


                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });*/

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

                                    Produto produto = new Produto();
                                    produto.setNome(nome);
                                    produto.setDescricao(descricao);
                                    produto.setQuantidade(quantidade);
                                    produto.setValor(valor);
                                    salvar(produto);
                                    Toast.makeText(getActivity(),"Cadastro realizado com sucesso",Toast.LENGTH_SHORT).show();


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



            // Inflate the layout for this fragment
            return view;
        }


}
