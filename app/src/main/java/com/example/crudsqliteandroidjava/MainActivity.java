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
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DaoContacto daoContacto;
    Adapter adapter;
    ArrayList<Contacto> lista = new ArrayList<Contacto>();
    Contacto contacto;

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
                DialogFragment vm;
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setTitle("Nuevo Registro");
                dialog.setCancelable(true);
                dialog.setContentView(R.layout.dialogo);

                dialog.show();
                final EditText dialogo_nombre = (EditText) dialog.findViewById(R.id.dialogo_nombre);
                final EditText dialogo_telefono = (EditText) dialog.findViewById(R.id.dialogo_telefono);
                final EditText dialogo_email = (EditText) dialog.findViewById(R.id.dialogo_email);
                final EditText dialogo_edad = (EditText) dialog.findViewById(R.id.dialogo_edad);
                final Button dialogo_agregar = (Button) dialog.findViewById(R.id.dialogo_agregar);
                final Button dialogo_cancelar = (Button) dialog.findViewById(R.id.dialogo_cancelar);

//                dialog.dialogo_agregar.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        try {
//                            contacto = new Contacto(
//                                    dialogo_nombre.getText().toString(),
//                                    dialogo_telefono.getText().toString(),
//                                    dialogo_email.getText().toString(),
//                                    Integer.parseInt(dialogo_edad.getText().toString()));
//
//                            daoContacto.insertar(contacto);
//                            adapter.notifyDataSetChanged();
//                            dialog.dismiss();
//                        } catch (Exception e) {
//                            Toast.makeText(MainActivity.this, "Error amiguito...!!", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });

//                dialogo_cancelar.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        dialog.dismiss();
//                    }
//                });
            }
        });


    }
}
