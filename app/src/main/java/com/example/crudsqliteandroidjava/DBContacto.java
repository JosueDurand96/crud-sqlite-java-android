package com.example.crudsqliteandroidjava;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DBContacto {
    SQLiteDatabase sqLiteDatabase;
    ArrayList<Contacto> lista = new ArrayList<Contacto>();
    Contacto contacto;
    Context context;
    String nombreDB = "BDContactos";
    String tabla = "create table if not exists contacto(id integer primary key autoincrement, nombre text, telefono text, email text, edad integer)";

    public DBContacto(Context context) {
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

        return (sqLiteDatabase.delete("contacto", "id=" + id, null)) > 0;
    }


    public boolean editar(Contacto contacto) {
        ContentValues contenedor = new ContentValues();
        contenedor.put("nombre", contacto.getNombre());
        contenedor.put("telefono", contacto.getTelefono());
        contenedor.put("email", contacto.getEmail());
        contenedor.put("edad", contacto.getEdad());

        return (sqLiteDatabase.update("contacto", contenedor, "id=" + contacto.getId(), null)) > 0;
    }

    public ArrayList<Contacto> verTodos() {
        lista.clear();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from contacto", null);
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                lista.add(new Contacto(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getInt(4)));
            } while (cursor.moveToNext());
        }
        return lista;
    }

    public Contacto verUno(int position) {
        Cursor cursor = sqLiteDatabase.rawQuery("select * from contacto", null);
        cursor.moveToPosition(position);
        contacto = new Contacto(cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getInt(4));

        return contacto;
    }

}
