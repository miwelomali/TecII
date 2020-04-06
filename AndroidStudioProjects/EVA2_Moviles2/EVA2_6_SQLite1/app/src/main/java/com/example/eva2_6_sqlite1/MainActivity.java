package com.example.eva2_6_sqlite1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteDatabase simpledb = this.openOrCreateDatabase("testing", MODE_PRIVATE, null);
        //El objeto simple es el objeto, testing es nombre de la db
        //El modo privado, le permite el no compartir informacion con cualquier tipo de app


        //Crear el query de la tabla
        simpledb.execSQL("create table if not exists t1(lastname varchar, firstname varchar," +
                "age varchar)");

        //insertar el query de la informacion
        simpledb.execSQL("insert into t1 values('Dino','Kevin', '23')");

        //Cerrar la base de datos
        simpledb.close();

        Toast.makeText(this, "Database creada", Toast.LENGTH_LONG).show();

    }
}
