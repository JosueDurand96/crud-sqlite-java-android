package com.example.crudsqliteandroidjava;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DaoContacto {
    SQLiteDatabase sqLiteDatabase;
    ArrayList<Contacto> lista= new ArrayList<Contacto>();
    Contacto contacto;
    Context context;
    String nombreDB = "BDContactos";
    String tabla = "create table if not exists contacto(id integer primary key autoincrement, nombre text, telefono text, email text, edad integer)";

    public DaoContacto(Context context) {
        this.context = context;
        sqLiteDatabase = context.openOrCreateDatabase(nombreDB, Context.MODE_PRIVATE, null);
        sqLiteDatabase.execSQL(tabla);
    }

    public boolean insertar(Contacto contacto) {
        ContentValues content = new ContentValues();
        content.put("nombre", contacto.getNombre());
        content.put("telefono", contacto.getEmail());
        content.put("email", contacto.getEmail());
        content.put("edad", contacto.getEdad());
        return (sqLiteDatabase.insert("contacto", null, content)) > 0;

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
