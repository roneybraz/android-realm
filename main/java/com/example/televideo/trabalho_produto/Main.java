package com.example.televideo.trabalho_produto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.List;
import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class Main extends AppCompatActivity {
    private ArrayList<String> listSalve = new ArrayList<String>();

    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Realm.init(this);
        realm = Realm.getDefaultInstance();


        Bundle args = getIntent().getExtras();
        final String nomeLista = args.getString("resultado");

        final ArrayList<Produtos> produto = new ArrayList<>();

        final ListView lista = (ListView)findViewById(R.id.man_listProduto);


        RealmResults<Produtos> realmProdutos = realm.where(Produtos.class).findAll();

        final ProdutoAdapter adapter = new ProdutoAdapter(this, R.layout.linha, realmProdutos);
        lista.setAdapter(adapter);

        final Spinner spinner = (Spinner) findViewById(R.id.main_spinnerCategoria);
        final List<String> list = new ArrayList<String>();
        list.add("Alimentos");
        list.add("Bebidas");
        list.add("Carne");
        list.add("Frios");
        list.add("Laticínios");
        list.add("Frutas");
        list.add("Verdura");
        list.add("Legumes");
        list.add("Higiene");
        list.add("Limpeza");
        list.add("Padaria");
        list.add("Outros");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        final CheckBox checkPerecivel=(CheckBox)findViewById(R.id.main_checkPerecivel);


        Button btnSalvar = (Button)findViewById(R.id.main_bntSalvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText txtProduto = (EditText)findViewById(R.id.main_txtProduto);
                EditText txtQuatidade=(EditText)findViewById(R.id.main_txtQuant);
                String categoria= String.valueOf(spinner.getSelectedItem());
                boolean check_Perecivel = checkPerecivel.isChecked();
                String perecivel;

                if(check_Perecivel) perecivel="Sim";
                else perecivel="Não";



                String nomeproduto= txtProduto.getText().toString();
                int quatidade= Integer.parseInt(txtQuatidade.getText().toString());


                Produtos p =new Produtos();
                p.setId(Produtos.autoIncrement());
                p.setQuantidade(quatidade);
                p.setNome_produto(nomeproduto);
                p.setCategoria(categoria);
                p.setNome_lista(nomeLista.toString());
                p.setCheckPerecivel(perecivel);

                realm.beginTransaction();
                realm.copyToRealm(p);
                realm.commitTransaction();

                produto.add(p);
                lista.setAdapter(adapter);



            }


        });

}

    @Override
    protected void onDestroy() {
        realm.close();
        super.onDestroy();
    }

}
