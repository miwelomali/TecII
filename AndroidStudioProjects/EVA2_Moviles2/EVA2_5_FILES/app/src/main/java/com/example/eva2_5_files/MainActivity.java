package com.example.eva2_5_files;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    final String ARCHIVO = "mi_archivo.txt";
    final int PERMISO_ESCRITURA = 1000;
    String sRutaSD;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //AQUI HABRIA QUE TOMAR DECISIONES SOBRE LOS PERMISOS
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edTxtTexto);
        sRutaSD = getExternalFilesDir(Environment.DIRECTORY_MUSIC).getPath();
        Toast.makeText(this, sRutaSD, Toast.LENGTH_LONG).show();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    PERMISO_ESCRITURA);

        }

    }

    public void onRead(View v) {
        try {
            //InputStream is = openFileInput(ARCHIVO);
            File file = new File (getExternalFilesDir(Environment.DIRECTORY_MUSIC), ARCHIVO);
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String sCade;
            try {
                while ((sCade = br.readLine()) != null) {
                    editText.append(sCade);
                    editText.append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void onWrite(View v) {


        try {
            //OutputStream os = openFileOutput(ARCHIVO, MODE_PRIVATE);
            File file = new File (getExternalFilesDir(Environment.DIRECTORY_MUSIC), ARCHIVO);
            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            String sCade = editText.getEditableText().toString();

            bw.write(sCade);
            bw.close();

        } catch (Exception e) {

        }

    }

    public void onWriteClase(View v) {
        String sCade = editText.getText().toString();
        try {
            OutputStream os = openFileOutput(ARCHIVO, 0);
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(sCade);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
