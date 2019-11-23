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

    public daoContacto(Context ctx) {
        this.context = ctx;
        sqLiteDatabase = ctx.openOrCreateDatabase(nombreDB, Context.MODE_WORLD_WRITEABLE, null);
        sqLiteDatabase.execSQL(tabla);
    }

    public boolean insertar(Contacto contacto) {
        return true;
    }

    public boolean eliminar(int id) {
        return true;
    }


    public boolean editar(Contacto contacto) {
        return true;
    }

    public ArrayList<Contacto> verTodos() {
        return lista;
    }

    public Contacto verUno(int id) {
        return contacto;
    }

}
