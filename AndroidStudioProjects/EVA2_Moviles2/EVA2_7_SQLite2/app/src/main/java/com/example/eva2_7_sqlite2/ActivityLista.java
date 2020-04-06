package com.example.eva2_7_sqlite2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityLista extends AppCompatActivity {
    String sApellido, sNombre, sEdad;
    ListView lstPersona;
    Persona[] cPersonas = {
    };


    PersonaAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        lstPersona = findViewById(R.id.listPersonas);
        //Obtener los datos dentro de la base de datos testing
        SQLiteDatabase simpledb = this.openOrCreateDatabase("testing", MODE_PRIVATE, null);
        String sql = "select * from t1";
        Cursor c1 = simpledb.rawQuery(sql, null);
        c1.moveToPosition(-1);

        while (c1.moveToNext()) {
            sApellido = c1.getString(0);
            sNombre = c1.getString(1);
            sEdad = c1.getString(2);
            cPersonas = addPersona(cPersonas.length, cPersonas, new Persona(R.drawable.avatar, sNombre, sApellido, sEdad));

        }
        lstPersona.setAdapter(new PersonaAdapter(this, R.layout.activity_persona, cPersonas));

    }

    public static Persona[] addPersona(int n, Persona[] personas, Persona x) {
        int i;

        // create a new array of size n+1
        Persona newarr[] = new Persona[n + 1];

        // insert the elements from
        // the old array into the new array
        // insert all elements till n
        // then insert x at n+1
        for (i = 0; i < n; i++)
            newarr[i] = personas[i];

        newarr[n] = x;

        return newarr;
    }
}
