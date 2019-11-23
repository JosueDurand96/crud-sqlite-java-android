package com.example.crudsqliteandroidjava;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {
    ArrayList<Contacto> lista;
    DaoContacto daoContacto;
    Contacto contacto;
    Activity activity;

    public Adapter(ArrayList<Contacto> lista, Activity activity, DaoContacto daoContacto) {
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
        if (v!=null){
            LayoutInflater layoutInflater =(LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        return null;
    }
}