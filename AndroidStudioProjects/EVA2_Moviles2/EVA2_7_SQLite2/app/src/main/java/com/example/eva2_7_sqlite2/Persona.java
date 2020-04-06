package com.example.eva2_7_sqlite2;

import android.app.Person;

public class Persona {
    private int imagen;
    private String nombre;
    private String apellido;
    private String edad;

    public Persona(int imagen, String nombre, String apellido, String edad) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public Persona() {
        imagen = R.drawable.avatar;
        nombre = "Kevin";
        apellido = "Dino";
        edad = "23";
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
}
