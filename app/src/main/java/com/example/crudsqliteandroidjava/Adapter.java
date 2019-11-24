package com.example.crudsqliteandroidjava;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {
    ArrayList<Contacto> lista = new ArrayList<Contacto>();
    DBContacto daoContacto;
    Contacto contacto;
    Activity activity;
    int id = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Adapter(Activity activity, ArrayList<Contacto> lista, DBContacto daoContacto) {
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
    public View getView(int position, final View view, ViewGroup parent) {
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
        txtnombre.setText(contacto.getNombre());
        txttelefono.setText(contacto.getTelefono());
        txtemail.setText(contacto.getEmail());
        txtedad.setText("" + contacto.getEdad());
        btneditar.setTag(position);
        btnEliminar.setTag(position);
        btneditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = Integer.parseInt(v.getTag().toString());
                final Dialog dialog = new Dialog(activity);
                dialog.setTitle("Editar Registro");
                dialog.setCancelable(true);
                dialog.setContentView(R.layout.dialogo);
                dialog.show();
                final EditText dialogo_nombre = (EditText) dialog.findViewById(R.id.dialogo_nombre);
                final EditText dialogo_telefono = (EditText) dialog.findViewById(R.id.dialogo_telefono);
                final EditText dialogo_email = (EditText) dialog.findViewById(R.id.dialogo_email);
                final EditText dialogo_edad = (EditText) dialog.findViewById(R.id.dialogo_edad);
                final Button dialogo_agregar = (Button) dialog.findViewById(R.id.dialogo_agregar);
                final Button dialogo_cancelar = (Button) dialog.findViewById(R.id.dialogo_cancelar);
                contacto = lista.get(pos);
                setId(contacto.getId());
                dialogo_nombre.setText(contacto.getNombre());
                dialogo_telefono.setText(contacto.getTelefono());
                dialogo_email.setText(contacto.getEmail());
                dialogo_edad.setText("" + contacto.getEdad());
                dialogo_agregar.setText("Guardar");
                dialogo_agregar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            contacto = new Contacto(
                                    getId(),
                                    dialogo_nombre.getText().toString(),
                                    dialogo_telefono.getText().toString(),
                                    dialogo_email.getText().toString(),
                                    Integer.parseInt(dialogo_edad.getText().toString()));
                            daoContacto.editar(contacto);
                            lista = daoContacto.verTodos();
                            notifyDataSetChanged();
                            dialog.dismiss();

                        } catch (Exception e) {
                            Toast.makeText(activity, "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dialogo_cancelar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

            }
        });
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                int pos = Integer.parseInt(view.getTag().toString());
                contacto = lista.get(pos);
                setId(contacto.getId());

                AlertDialog.Builder alertBuild = new AlertDialog.Builder(activity);
                alertBuild.setMessage("¿Desea eliminar este registro?");
                alertBuild.setCancelable(false);
                alertBuild.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        daoContacto.eliminar(getId());
                        lista = daoContacto.verTodos();
                        notifyDataSetChanged();

                    }
                });
                alertBuild.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertBuild.show();

            }
        });


        return v;
    }
}
