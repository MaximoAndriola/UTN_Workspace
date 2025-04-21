package org.example.Model;

public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private int anio_publicacion;
    private int unidades_disponibles;

    public Libro(String titulo, String autor, int anio_publicacion, int unidades_disponibles) {
        this.id = 0;
        this.titulo = titulo;
        this.autor = autor;
        this.anio_publicacion = anio_publicacion;
        this.unidades_disponibles = unidades_disponibles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnio_publicacion() {
        return anio_publicacion;
    }

    public void setAnio_publicacion(int anio_publicacion) {
        this.anio_publicacion = anio_publicacion;
    }

    public int getUnidades_disponibles() {
        return unidades_disponibles;
    }

    public void setUnidades_disponibles(int unidades_disponibles) {
        this.unidades_disponibles = unidades_disponibles;
    }

    @Override
    public String toString() {
        return "Libro(" +
                "id: " + id +
                ", titulo: " + titulo +
                ", autor: " + autor +
                ", anio_publicacion: " + anio_publicacion +
                ", unidades_disponibles: " + unidades_disponibles +
                ")";
    }
}
