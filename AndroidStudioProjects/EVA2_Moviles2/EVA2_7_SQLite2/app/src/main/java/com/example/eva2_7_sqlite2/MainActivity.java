package com.example.eva2_7_sqlite2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edTxtNombre, edTxtApellido, edTxtEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edTxtNombre = findViewById(R.id.edTxtNombre);
        edTxtApellido = findViewById(R.id.edTxtApellido);
        edTxtEdad = findViewById(R.id.edTxtEdad);
    }


    public void onCLickInsertarDato(View v) {
        SQLiteDatabase simpledb = this.openOrCreateDatabase("testing", MODE_PRIVATE, null);
        //El objeto simple es el objeto, testing es nombre de la db
        //El modo privado, le permite el no compartir informacion con cualquier tipo de app


        //Crear el query de la tabla
        simpledb.execSQL("create table if not exists t1(lastname varchar, firstname varchar," +
                "age varchar)");

        //Declarar las variables con los valores registrados por el usuario
        String sNombre = edTxtNombre.getText().toString();
        String sApellido = edTxtApellido.getText().toString();
        String sEdad = edTxtEdad.getText().toString();

        //insertar el query de la informacion

        //simpledb.execSQL("insert into t1 values('Dino','Kevin', '100')");
        //Remplazar la linea de ejecucion por:
        String sSecuencia = "insert into t1 values('" + sApellido + "','" + sNombre + "','" + sEdad + "')";
        simpledb.execSQL(sSecuencia);
        //Cerrar la base de datos
        simpledb.close();

        Toast.makeText(this, "Datos registrados", Toast.LENGTH_LONG).show();
    }

    public void onConsultarDatos(View v) {
        Intent intento = new Intent(this, ActivityLista.class);
        startActivity(intento);
    }
}
