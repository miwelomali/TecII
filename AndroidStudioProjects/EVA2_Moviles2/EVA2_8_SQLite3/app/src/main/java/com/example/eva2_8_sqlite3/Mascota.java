package com.example.eva2_8_sqlite3;

public class Mascota {

    private String nombre;
    private int edad;

    private long id; // El ID de la BD

    public Mascota(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // COnstructor para inicializar la base de datos
    public Mascota(String nombre, int edad, long id) {
        this.nombre = nombre;
        this.edad = edad;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
