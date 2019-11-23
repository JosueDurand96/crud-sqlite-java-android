package com.example.crudsqliteandroidjava;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class daoContacto {
    SQLiteDatabase sqLiteDatabase;
    ArrayList<Contacto> lista;
    Contacto contacto;
    Context context;
    String nombreDB = "BDContactos";
    String tabla = "create table if not exists contacto(id integer primary key autoincrement, nombre text, telefono text, email text, edad integer)";

    public daoContacto(Context context){
        this.context = context;

    }
}
