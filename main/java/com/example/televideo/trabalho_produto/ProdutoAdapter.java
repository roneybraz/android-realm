package com.example.televideo.trabalho_produto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import io.realm.RealmResults;

/**
 * Created by Televideo on 24/09/2017.
 */

public class ProdutoAdapter extends ArrayAdapter<Produtos> {

    Context contexto;
    RealmResults<Produtos> produto;

    public ProdutoAdapter(Context context, int resource, RealmResults<Produtos> objects){
        super(context, resource, objects);
        this.contexto = context;
        this.produto = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        View linhaView = LayoutInflater.from(contexto).inflate(R.layout.linha, parent, false);


        TextView COD=(TextView)linhaView.findViewById(R.id.linha_lblCod);
        TextView quantidade = (TextView)linhaView.findViewById(R.id.linha_lblQuant);
        TextView nome_produto = (TextView)linhaView.findViewById(R.id.linha_lblNomeProduto);
        TextView categoria = (TextView)linhaView.findViewById(R.id.linha_lblCategoria);
        TextView nome_lista = (TextView)linhaView.findViewById(R.id.linha_lblNomeLista);
        TextView checkPerecivel=(TextView)linhaView.findViewById(R.id.linha_lblPerecivel);



        COD.setText(Integer.toString(produto.get(position).getId()));

        quantidade.setText(Integer.toString(produto.get(position).getQuantidade()));

        nome_produto.setText(produto.get(position).getNome_produto());

        categoria.setText(produto.get(position).getCategoria());

        nome_lista.setText(produto.get(position).getNome_lista());

        checkPerecivel.setText(produto.get(position).getCheckPerecivel());

        return linhaView;



    }

}
