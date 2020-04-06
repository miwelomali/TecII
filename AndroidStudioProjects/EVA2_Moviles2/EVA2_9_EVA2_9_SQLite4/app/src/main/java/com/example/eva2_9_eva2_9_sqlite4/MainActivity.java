package com.example.eva2_9_eva2_9_sqlite4;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        File dbfile = new File("/sdcard/android/com.example.eva2_9_eva2_9_sqlite4/databases/testing.db");
        SQLiteDatabase simpledb;
        String SDcardPath = Environment
                .getExternalStorageDirectory()
                .getPath() + "/testing";

        simpledb = SQLiteDatabase.openDatabase(
                SDcardPath,
                null,
                SQLiteDatabase.CREATE_IF_NECESSARY
        );
        //Comprobar si la base de datos esta abierta
        System.out.println("Its open:" + simpledb.isOpen());
        Toast.makeText(this, "Is it open?" + simpledb.isOpen(), Toast.LENGTH_SHORT).show();

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
