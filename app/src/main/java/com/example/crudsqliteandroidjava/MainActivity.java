package com.example.crudsqliteandroidjava;

import android.os.Bundle;

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
        lista=daoContacto.verTodos();
        adapter


    }
}
