package com.example.televideo.trabalho_produto;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        final Button bnt_ok;bnt_ok =(Button)findViewById(R.id.main_bntOK);



        bnt_ok.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                TextView txt_NomeLista=(TextView)findViewById(R.id.home_txtNomeLista);

                String nome_lista;
                nome_lista= txt_NomeLista.getText().toString();


                Intent intent = new Intent(getContext(), Main.class);
                Bundle params = new Bundle();
                params.putString("resultado",nome_lista);
                intent.putExtras(params);
                startActivity(intent);

            }
        });

    }
    private Context getContext()
    {
        return this;
    }

}
