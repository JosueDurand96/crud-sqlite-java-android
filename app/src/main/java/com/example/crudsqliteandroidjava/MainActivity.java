package com.example.crudsqliteandroidjava;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DaoContacto daoContacto;
    Adapter adapter;
    ArrayList<Contacto> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        daoContacto = new DaoContacto(this);
        lista = daoContacto.verTodos();
        adapter = new Adapter(this, lista, daoContacto);

        ListView lstContacto = (ListView) findViewById(R.id.lstContacto);

        ImageView imgAgregar =(ImageView)findViewById(R.id.imgAgregar);

        lstContacto.setAdapter(adapter);
        lstContacto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        imgAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
