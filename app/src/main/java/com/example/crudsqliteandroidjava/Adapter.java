package com.example.crudsqliteandroidjava;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {
    ArrayList<Contacto> lista= new ArrayList<Contacto>();
    DaoContacto daoContacto;
    Contacto contacto;
    Activity activity;

    public Adapter(Activity activity, ArrayList<Contacto> lista, DaoContacto daoContacto) {
        this.lista = lista;
        this.activity = activity;
        this.daoContacto = daoContacto;

    }


    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Contacto getItem(int position) {
        contacto = lista.get(position);
        return null;
    }

    @Override
    public long getItemId(int position) {
        contacto = lista.get(position);
        return contacto.getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View v = view;
        if (v == null) {
            LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = layoutInflater.inflate(R.layout.item, null);
        }
        contacto = lista.get(position);
         TextView txtnombre = (TextView) v.findViewById(R.id.item_nombre);
        TextView txttelefono = (TextView) v.findViewById(R.id.item_telefono);
        TextView txtemail = (TextView) v.findViewById(R.id.item_email);
        TextView txtedad = (TextView) v.findViewById(R.id.item_edad);
        ImageView btneditar = (ImageView) v.findViewById(R.id.item_btneditar);
        ImageView btnEliminar = (ImageView) v.findViewById(R.id.item_btneliminar);
        txtnombre.setText(contacto.nombre);
        txttelefono.setText(contacto.telefono);
        txtemail.setText(contacto.email);
        txtedad.setText(""+contacto.edad);
        btneditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        return v;
    }
}
