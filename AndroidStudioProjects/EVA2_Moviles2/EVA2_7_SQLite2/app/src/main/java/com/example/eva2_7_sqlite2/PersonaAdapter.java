package com.example.eva2_7_sqlite2;

import android.app.Activity;
import android.app.Person;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.ParseException;
import java.util.ArrayList;

public class PersonaAdapter extends ArrayAdapter<Persona> {
    private int resource;
    private Context context;
    Persona[] Personas;

    public PersonaAdapter(Context context, int resource, Persona[] objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.Personas = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imgPersona;
        TextView txtVwNombre, txtVwApellido, txtVwEdad;

        if (convertView == null) {
            LayoutInflater iInflator = ((Activity) context).getLayoutInflater();
            convertView = iInflator.inflate(resource, parent, false);
        }
        imgPersona = convertView.findViewById(R.id.imgVwImagen);
        txtVwNombre = convertView.findViewById(R.id.txtVwNombre);
        txtVwApellido = convertView.findViewById(R.id.txtVwApellido);
        txtVwEdad = convertView.findViewById(R.id.txtVwEdad);

        imgPersona.setImageResource(Personas[position].getImagen());
        txtVwNombre.setText(Personas[position].getNombre());
        txtVwApellido.setText(Personas[position].getApellido());
        txtVwEdad.setText(Personas[position].getEdad());
        return convertView;

    }


}
