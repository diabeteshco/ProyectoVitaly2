package com.example.practica2;

public class Opcion {
    String titulo;
    int imagen;

    public Opcion(String titulo, int imagen) {
        this.titulo = titulo;
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getImagen() {
        return imagen;
    }
}
