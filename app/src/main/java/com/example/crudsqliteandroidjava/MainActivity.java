package com.example.crudsqliteandroidjava;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
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

        daoContacto = new DaoContacto(MainActivity.this);
        lista = daoContacto.verTodos();
        adapter = new Adapter(this, lista, daoContacto);

        ListView lstContacto = (ListView) findViewById(R.id.lstContacto);

        ImageView imgAgregar = (ImageView) findViewById(R.id.imgAgregar);

        lstContacto.setAdapter(adapter);
        lstContacto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        imgAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setTitle("Nuevo Registro");
                dialog.setCancelable(true);
                dialog.setContentView(R.layout.dialogo);
                dialog.show();
                EditText dialogo_nombre = (EditText) findViewById(R.id.dialogo_nombre);
                EditText dialogo_telefono = (EditText) findViewById(R.id.dialogo_telefono);
                EditText dialogo_email = (EditText) findViewById(R.id.dialogo_email);
                EditText dialogo_edad = (EditText) findViewById(R.id.dialogo_edad);

                Button dialogo_agregar =(Button)findViewById(R.id.dialogo_agregar);
                Button dialogo_cancelar =(Button)findViewById(R.id.dialogo_cancelar);
            }
        });


    }
}
