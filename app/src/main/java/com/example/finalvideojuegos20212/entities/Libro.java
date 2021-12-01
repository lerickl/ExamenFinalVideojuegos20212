package com.example.finalvideojuegos20212.entities;

public class Libro {
    public int id;
    public String nombre;
    public String vistas;
    public String fecha_de_estreno;
    public String tienda_1;
    public String tienda_2;
    public String tienda_3;
    public String imagen_url;
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Libro(int id, String nombre, String vistas, String fecha_de_estreno, String tienda_1, String tienda_2, String tienda_3, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.vistas = vistas;
        this.fecha_de_estreno = fecha_de_estreno;
        this.tienda_1 = tienda_1;
        this.tienda_2 = tienda_2;
        this.tienda_3 = tienda_3;
        this.imagen_url = imagen;
    }
}
