package com.example.televideo.trabalho_produto;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Televideo on 24/09/2017.
 */

public class Produtos extends RealmObject {

    @PrimaryKey
    private int id;
    private int quantidade;
    private String nome_produto;
    private String categoria;
    private String nome_lista;
    private String checkPerecivel;

    public String getCheckPerecivel() {
        return checkPerecivel;
    }

    public void setCheckPerecivel(String checkPerecivel) {
        this.checkPerecivel = checkPerecivel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNome_lista() {
        return nome_lista;
    }

    public void setNome_lista(String nome_lista) {
        this.nome_lista = nome_lista;
    }

    public static int autoIncrement(){
        int key = 1;
        Realm realm = Realm.getDefaultInstance();
        try{
            key = realm.where(Produtos.class).max("id")
                    .intValue() + 1;
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        return key;
    }



}
